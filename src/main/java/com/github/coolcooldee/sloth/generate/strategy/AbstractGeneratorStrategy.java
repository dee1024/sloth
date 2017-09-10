package com.github.coolcooldee.sloth.generate.strategy;

import com.github.coolcooldee.sloth.Application;
import com.github.coolcooldee.sloth.parameter.*;
import com.google.common.io.Files;
import com.github.coolcooldee.sloth.generate.strategy.impl.EnableGeneratedFile;
import com.github.coolcooldee.sloth.source.db.mysql.DBConnection;
import com.github.coolcooldee.sloth.source.db.mysql.Table;
import com.github.coolcooldee.sloth.source.db.mysql.TableUtil;
import com.github.coolcooldee.sloth.utils.DirectoryUtil;
import com.github.coolcooldee.sloth.utils.FileUtil;
import com.github.coolcooldee.sloth.utils.StringUtil;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sloth on 16/6/22.
 */
public abstract class AbstractGeneratorStrategy implements GeneratorStrategy, EnableSupportUserInputPatamter {

    static Logger logger = LoggerFactory.getLogger(AbstractGeneratorStrategy.class);


    public void execute(){
        //genVersionControllFileAndBackup();

        if(!StringUtil.isEmpty(UserInputParamters.getDbTableInUserParam())){
            String[] args = UserInputParamters.getDbTableInUserParam().split(",");
            genEnableGeneratedFileIn(getAllCustomizedFiles(), args);
            return;
        }
        // step 1
        copyDefaultStaticResourcesFile();
        // step 2
        genEnableGeneratedFileIn(getAllCommonFiles());
        // step 3
        genEnableGeneratedFileIn(getAllCustomizedFiles());
    }


    /**
     * get all files in the path "resources/templae/common/"
     * @return
     */
    private  EnableGeneratedFile[] getAllCommonFiles(){
        return getAllTemplateFilesByTemplatePath((SourceProjectPathParamters.getSourceProjectClassPath()
                +"template/common/").replace("/",File.separator));
    }

    /**
     * get all files by strategy, e.g: when the strategy is "ssm", files are in the path "resources/templae/ssm/"
     * @return
     */
    private  EnableGeneratedFile[] getAllCustomizedFiles(){
        return getAllTemplateFilesByTemplatePath((SourceProjectPathParamters.getSourceProjectClassPath()+"template/"+getSpecifiedStr()+"/").replace("/",File.separator));
    }

    protected abstract boolean ignoreDefaultDBCode();

    protected abstract boolean ignoreDefaultApplicationCode();

    protected abstract boolean ignoreDefaultResourceFile();

    protected abstract boolean ignoreDefaultAssemblyFile();

    protected abstract boolean ignoreDefaultShellScriptFiles();

    protected abstract boolean ignoreDefaultPomFile();

    protected abstract boolean ignoreDefaultIndexControllerCode();

    protected abstract boolean ignoreDefaultTemplateFile();

    private void genEnableGeneratedFileIn(EnableGeneratedFile[] enableGeneratedFiles){
        genEnableGeneratedFileIn(enableGeneratedFiles, null);
    }

    /**
     * generate file with template
     * @param enableGeneratedFiles  file generating
     * @param genSpecifiedTableNames  specified tables name, if null , gen all tables
     */
    private void genEnableGeneratedFileIn(EnableGeneratedFile[] enableGeneratedFiles, String[] genSpecifiedTableNames) {
        boolean isGenAllTables = true;
        Set<String> genSpecifiedTableNameslist = new HashSet<>();
        if(genSpecifiedTableNames!=null){
            isGenAllTables = false;
            for(String genSpecifiedTableName : genSpecifiedTableNames){
                genSpecifiedTableNameslist.add(genSpecifiedTableName);
            }
        }
        //DB CONNECTION INIT
        DBConnection.init(DBSourceParameters.getSourceDbHost(), DBSourceParameters.getSourceDbPort(), DBSourceParameters.getSourceDbSchema(), DBSourceParameters.getSourceDbUsername(), DBSourceParameters.getSourceDbPassword());
        Connection connection = DBConnection.getInstance();
        //FETCH ALL TABLE INFO
        List<Table> tables = new ArrayList<Table>();
        try {
            tables = TableUtil.getTables(connection, TargetProjectParameters.getTargetPackage(), new String[] {""});
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if(tables.size()>0)
            TemplateParameters.getTemplateParameterInfo().setAllTablesName(tables.get(0).getAllTablesName());
        //
        for (int i = 0; i < enableGeneratedFiles.length; i++) {
            EnableGeneratedFile enableGeneratedFile = enableGeneratedFiles[i];
            String targetFileName = enableGeneratedFile.getTargetFileName();
            if(targetFileName.indexOf("${model}")>-1){
                for(Table table : tables){
                    String modelName = enableGeneratedFile.getOriginalModelName(table.getUpperFirstLetterName());
                    if(isGenAllTables) {
                        baseGen(enableGeneratedFile, table, modelName);
                    }else if(genSpecifiedTableNameslist!=null){ // 只生成指定的文件
                        if(genSpecifiedTableNameslist.contains(table.getName())){
                            baseGen(enableGeneratedFile, table, modelName);
                        }
                    }
                }
            }else if(targetFileName.indexOf("${jooqModel}")>-1){
                for(Table table : tables){
                    String jooqModelName = enableGeneratedFile.getOriginalModelName(table.getJooqName());
                    if(isGenAllTables) {
                        baseGen(enableGeneratedFile, table, jooqModelName);
                    }else if(genSpecifiedTableNameslist!=null){ // 只生成指定的文件
                        if(genSpecifiedTableNameslist.contains(table.getName())){
                            baseGen(enableGeneratedFile, table, jooqModelName);
                        }
                    }
                }
            }else{
                if(isGenAllTables) {
                    baseGen(enableGeneratedFile);
                }

            }
        }
    }

    /**
     * copy default static resources file
     */
    private void copyDefaultStaticResourcesFile()  {
        File src = new File(SourceProjectPathParamters.getSourceProjectStaticFilePath());
        File dest = new File(TargetProjectParameters.getTargetProjectStaticResourceStorePath());
        Set<String> ignoreFileSuffixs = new HashSet<>();
        ignoreFileSuffixs.add(".ftl");
        DirectoryUtil.copyFolder(src,dest,ignoreFileSuffixs);

    }

    private void genVersionControllFileAndBackup() {
        File file = new File(TargetProjectParameters.getTargetProjectStorePath()+"rkill.ver");
        try {
            //TODO
            Files.append("a",file, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void baseGen(EnableGeneratedFile[] codeCategories){
        for(int i=0; i<codeCategories.length; i++){
            baseGen(codeCategories[i], getTemplateBaseDate());
        }
    }


    private void baseGen(EnableGeneratedFile codeCategory){
        baseGen(codeCategory, getTemplateBaseDate());
    }


    private void baseGen(EnableGeneratedFile codeCategory, Object data){
        baseGen(codeCategory, data , "");
    }

    /**
     * generate target file with enableGeneratedFile Object、template data、modelName,
     *
     * @param enableGeneratedFile
     * @param templateData
     * @param modelName  optional paramter
     */
    private void baseGen(EnableGeneratedFile enableGeneratedFile, Object templateData, String modelName){
        if(enableGeneratedFile ==null)
            return;
        String templateName = enableGeneratedFile.getTemplateFileName();
        String templateRelativeDir = enableGeneratedFile.getTemplateFileRelativeDir();
        String targetFileAbsoluteDir = enableGeneratedFile.getTargetFileAbsoluteBaseDir() + enableGeneratedFile.getTargetFileRelativeDir();
        String targetFileName = enableGeneratedFile.getTargetFileName().replace("${model}", modelName) ;
        gen(templateData, templateRelativeDir, templateName, targetFileAbsoluteDir, targetFileName);
    }

    protected Object getTemplateBaseDate(){
        return TemplateParameters.getTemplateParameterInfo();
    }


    /**
     * base freemarker genarate method
     * @param templateData
     * @param templateFileRelativeDir
     * @param templateFileName
     * @param targetFileAbsoluteDir
     * @param targetFileName
     */
    private void gen(Object templateData, String templateFileRelativeDir, String templateFileName, String targetFileAbsoluteDir, String targetFileName){
        try{
            Configuration configuration = new Configuration();
            configuration.setClassForTemplateLoading(Application.class, templateFileRelativeDir);
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            Template template = configuration.getTemplate(templateFileName);
            template.setEncoding(encoding);
            if(!targetFileAbsoluteDir.endsWith(File.separator))
                targetFileAbsoluteDir+=File.separator;
            FileUtil.mkdir(targetFileAbsoluteDir);
            Writer fw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(targetFileAbsoluteDir + targetFileName)),encoding));
            template.process(templateData, fw);
        }catch (Throwable e){
            logger.error("Can not found the template file, path is \"" + templateFileRelativeDir + templateFileName +".\"");
            e.printStackTrace();
            throw new RuntimeException("IOException occur , please check !! ");
        }
    }


    private  EnableGeneratedFile[] getAllTemplateFilesByTemplatePath(String templatePath){
        List<EnableGeneratedFile> enableGeneratedFileList = new ArrayList<EnableGeneratedFile>();
        List<File> files = DirectoryUtil.getListFiles(templatePath);
        for (File file : files){
            if(!file.getName().endsWith(".ftl"))
                continue;
            String templateFileRelativeDir = file.getAbsolutePath().replace(SourceProjectPathParamters.getSourceProjectClassPath(),File.separator).replace(file.getName(),"");

            String templateFileName = file.getName();
            String targetFileAbsoluteBaseDir = TargetProjectParameters.getTargetProjectStorePath();
            String targetFileRelativeDir = file.getAbsolutePath().replace(templatePath,"").replace("$packagename",TargetProjectParameters.getTargetPackagePath()).replace(file.getName(),"");
            //String targetFileName = file.getName().replace(".ftl","");
            String targetFileName = file.getName().substring(0,file.getName().length()-4);

            GeneratedFile fileGenerate = new GeneratedFile(templateFileRelativeDir,templateFileName,targetFileAbsoluteBaseDir,targetFileRelativeDir,targetFileName);
            enableGeneratedFileList.add(fileGenerate);
        }
        return  enableGeneratedFileList.toArray(new EnableGeneratedFile[enableGeneratedFileList.size()]);
    }

}
