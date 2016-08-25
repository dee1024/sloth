package com.xsj.generate.strategy.impl.ssj;

import com.xsj.generate.strategy.impl.EnableGeneratedFile;
import com.xsj.parameter.TargetProjectParameters;
import com.xsj.utils.StringUtil;


/**
 *
 * Spring + SpringMVC + Jooq 代码类别
 * Created by dee on 16/6/16.
 */
public enum SSJCodeCategory implements EnableGeneratedFile {

    SERVICE_JOOQ(
            "*Service.java",
            "service/",
            "service.ftl",
            "/template/ssj/"
    ),

    SERVICEIMPL_JOOQ(
            "*ServiceImpl.java",
            "service/impl/",
            "serviceImpl.ftl",
            "/template/ssj/"
    ),
    ;

    /**
     * @param templateFileRelativeDir 模版相对地址 ( 相对于 classpath 目录, 必须以 "/" 开头)
     * @param templateFileName 模版名字
     * @param targetFileRelativeDir 目标文件保存的相对路径目录
     * @param targetFileName 目标文件名字
     */
    private SSJCodeCategory(String targetFileName, String targetFileRelativeDir, String templateFileName, String templateFileRelativeDir){
        this.targetFileName = targetFileName;
        this.targetFileRelativeDir = targetFileRelativeDir;
        this.templateFileRelativeDir = templateFileRelativeDir;
        this.templateFileName = templateFileName;
    }

    public static EnableGeneratedFile[] getSelfAll()  {
        int length = SSJCodeCategory.values().length;
        EnableGeneratedFile[] enableGeneratedFiles = new EnableGeneratedFile[length];
        for (int i = 0; i < length; i++) {
            enableGeneratedFiles[i] = SSJCodeCategory.values()[i];
        }
        return enableGeneratedFiles;
    }

    private String targetFileName;

    private String targetFileRelativeDir;

    private String templateFileRelativeDir;

    private String templateFileName;

    /**
     * 按照jooq的代码规范, 表格式为userDetail, 生成的模型命名为 Userdetail
     * @param originalModelName
     * @return
     */
    @Override
    public String getOriginalModelName(String originalModelName){
        String targetModelName ;
        if(StringUtil.isEmpty(originalModelName))
            return "";
        targetModelName = originalModelName.toLowerCase();
        return StringUtil.upperFirst(targetModelName);

    }

    @Override
    public String getTargetFileName() {
        return targetFileName;
    }

    public String getTargetFileAbsoluteBaseDir() {
        return TargetProjectParameters.getTargetProjectStorePath();
    }

    @Override
    public String getTargetFileRelativeDir() {
        return targetFileRelativeDir;
    }

    @Override
    public String getTemplateFileRelativeDir() {
        return templateFileRelativeDir;
    }

    @Override
    public String getTemplateFileName() {
        return templateFileName;
    }

}
