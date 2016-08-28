package com.xsj.generate.strategy;

import com.google.common.io.Files;
import com.xsj.Application;
import com.xsj.generate.strategy.impl.EnableGeneratedFile;
import com.xsj.generate.strategy.impl.support.TemplateParameterInfo;
import com.xsj.parameter.*;
import com.xsj.source.db.mysql.DBConnection;
import com.xsj.source.db.mysql.Table;
import com.xsj.source.db.mysql.TableUtil;
import com.xsj.utils.DirectoryUtil;
import com.xsj.utils.FileUtil;
import com.xsj.utils.StringUtil;
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
 * Created by dee on 16/6/22.
 */
public abstract class AbstractGeneratorStrategy implements GeneratorStrategy, EnableSupportUserInputPatamter {

    static Logger logger = LoggerFactory.getLogger(AbstractGeneratorStrategy.class);

    /**
     * 执行生成任务
     *
     */
    public void execute(){
        //genVersionControllFileAndBackup();

        if(StringUtil.isEmpty(UserInputParamters.getDbTableInUserParam())){
            // step 1
            copyDefaultStaticResourcesFile();
            // step 2
            genEnableGeneratedFileIn(getAllCommonFiles());
            // step 3
            genEnableGeneratedFileIn(getAllCustomizedFiles());

        }else{
            String[] args = UserInputParamters.getDbTableInUserParam().split(",");
            genEnableGeneratedFileIn(getAllCustomizedFiles(), args);
        }
    }


    /**
     * 到公共的模版路径下, 获取所有的公共的模版文件
     * @return
     */
    private  EnableGeneratedFile[] getAllCommonFiles(){
        return getAllTemplateFilesByTemplatePath(SourceProjectPathParamters.getSourceProjectClassPath()+"template/common/");
    }

    /**
     * 根据指定的策略到对应的目录下, 获取在该策略下所有定制化的模版文件
     * 如果有与公共生成文件重名的, 会优先使用定制化的生成规则覆盖默认的
     * @return
     */
    private  EnableGeneratedFile[] getAllCustomizedFiles(){
        return getAllTemplateFilesByTemplatePath(SourceProjectPathParamters.getSourceProjectClassPath()+"template/"+getSpecifiedStr()+"/");
    }

    /**
     * 是否忽略默认的DB代码生成,包括 DB.java 和DBConfig.java
     * @return
     */
    protected abstract boolean ignoreDefaultDBCode();

    /**
     * 是否忽略启动文件生成, Application.java
     * @return
     */
    protected abstract boolean ignoreDefaultApplicationCode();

    /**
     * 是否忽略资源文件, application.properties
     * @return
     */
    protected abstract boolean ignoreDefaultResourceFile();

    /**
     * 是否忽略POM文件, pom.xml
     * @return
     */
    protected abstract boolean ignoreDefaultAssemblyFile();

    /**
     * 是否忽略脚本文件文件生成, 包括 mvn.sh、start.sh 等
     * @return
     */
    protected abstract boolean ignoreDefaultShellScriptFiles();

    /**
     * 是否忽略POM文件生成, pom.xml
     * @return
     */
    protected abstract boolean ignoreDefaultPomFile();

    /**
     * 是否忽略 IndexController 文件生成, IndexController.java
     * @return
     */
    protected abstract boolean ignoreDefaultIndexControllerCode();

    /**
     * 是否忽略 页面模版文件生成
     * @return
     */
    protected abstract boolean ignoreDefaultTemplateFile();


    /**
     * generate file with template
     */
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
            if(targetFileName.indexOf("*")>-1){
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
        String targetFileName = enableGeneratedFile.getTargetFileName().replace("*", modelName) ;
        gen(templateData, templateRelativeDir, templateName, targetFileAbsoluteDir, targetFileName);
    }

    protected Object getTemplateBaseDate(){
        return TemplateParameters.getTemplateParameterInfo();
    }


    /**
     * 最基础的Freemarker生成方法
     * @param templateData 渲染模版所需要的数据
     * @param templateFileRelativeDir 模版文件的 "相对路径", 该路径必须以 "/" 开头 ( 该相对路径是相对于 classpath 目录, 一般是指项目的 resources 目录 )
     * @param templateFileName 模版文件的名字
     * @param targetFileAbsoluteDir 目标文件的 "绝对路径"
     * @param targetFileName 目标文件的名字
     */
    private void gen(Object templateData, String templateFileRelativeDir, String templateFileName, String targetFileAbsoluteDir, String targetFileName){
        try{
            Configuration configuration = new Configuration();
            configuration.setClassForTemplateLoading(Application.class, templateFileRelativeDir);
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            Template template = configuration.getTemplate(templateFileName);
            template.setEncoding(encoding);
            if(!targetFileAbsoluteDir.endsWith("/"))
                targetFileAbsoluteDir+="/";
            FileUtil.mkdir(targetFileAbsoluteDir);
            Writer fw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(targetFileAbsoluteDir + targetFileName)),encoding));
            template.process(templateData, fw);
        }catch (Throwable e){
            logger.error("Can not found the template file, path is \"" + templateFileRelativeDir + templateFileName +". \"");
            e.printStackTrace();
            throw new RuntimeException("IOException occur , please check !! ");
        }
    }

    /**
     * 获取某个路径下的所有模版文件, 以 .ftl 结尾的
     * @param templatePath
     * @return
     */
    private  EnableGeneratedFile[] getAllTemplateFilesByTemplatePath(String templatePath){
        List<EnableGeneratedFile> enableGeneratedFileList = new ArrayList<EnableGeneratedFile>();
        List<File> files = DirectoryUtil.getListFiles(templatePath);
        for (File file : files){
            if(!file.getName().endsWith(".ftl"))
                continue;
            String templateFileRelativeDir = file.getAbsolutePath().replace(SourceProjectPathParamters.getSourceProjectClassPath(),"/").replace(file.getName(),"");
            String templateFileName = file.getName();
            String targetFileAbsoluteBaseDir = TargetProjectParameters.getTargetProjectStorePath();
            String targetFileRelativeDir = file.getAbsolutePath().replace(templatePath,"").replace("$packagename",TargetProjectParameters.getTargetPackagePath()).replace(file.getName(),"");
            //删除最后面的一个.ftl, 其他的不删除, 不能使用replace, 只能去除后四个字符
            //String targetFileName = file.getName().replace(".ftl","");
            String targetFileName = file.getName().substring(0,file.getName().length()-4);

            GeneratedFile fileGenerate = new GeneratedFile(templateFileRelativeDir,templateFileName,targetFileAbsoluteBaseDir,targetFileRelativeDir,targetFileName);
            enableGeneratedFileList.add(fileGenerate);
        }
        return  enableGeneratedFileList.toArray(new EnableGeneratedFile[enableGeneratedFileList.size()]);
    }

}
