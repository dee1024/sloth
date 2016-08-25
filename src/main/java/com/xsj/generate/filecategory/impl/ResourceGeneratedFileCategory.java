package com.xsj.generate.filecategory.impl;


import com.xsj.generate.strategy.impl.EnableGeneratedFile;
import com.xsj.parameter.TargetProjectParameters;

/**
 * 资源文件类别
 * 如: pom.xml、start.sh
 * Created by dee on 16/6/16.
 */
@Deprecated
public enum ResourceGeneratedFileCategory implements EnableGeneratedFile {

    APPLICAION_PRO(
            "application.properties",
            "",
            "properties.ftl",
            "/template/common/"
    ),

    ;

    /**
     *
     * @param targetFileName          目标文件名字
     * @param targetFileRelativeDir   目标文件保存的相对径目录(相对于项目的根目录)
     * @param templateFileName        模版名字
     * @param templateFileRelativeDir 模版相对地址 ( 相对于 classpath 目录, 必须以 "/" 开头)
     *
     */
    private ResourceGeneratedFileCategory(String targetFileName, String targetFileRelativeDir, String templateFileName, String templateFileRelativeDir) {
        this.targetFileName = targetFileName;
        this.targetFileRelativeDir = targetFileRelativeDir;
        this.templateFileRelativeDir = templateFileRelativeDir;
        this.templateFileName = templateFileName;
    }

    public static EnableGeneratedFile[] getSelfAll()  {
        int length = ResourceGeneratedFileCategory.values().length;
        EnableGeneratedFile[] enableGeneratedFiles = new EnableGeneratedFile[length];
        for (int i = 0; i < length; i++) {
            enableGeneratedFiles[i] = ResourceGeneratedFileCategory.values()[i];
        }
        return enableGeneratedFiles;
    }

    private String targetFileName;

    private String targetFileRelativeDir;

    private String templateFileRelativeDir;

    private String templateFileName;

    public String getOriginalModelName(String originalModelName) {
        return originalModelName;
    }

    public String getTargetFileName() {
        return targetFileName;
    }

    public String getTargetFileAbsoluteBaseDir() {
        return TargetProjectParameters.getTargetProjectResourceStorePath();
    }

    public String getTargetFileRelativeDir() {
        return targetFileRelativeDir;
    }

    public String getTemplateFileRelativeDir() {
        return templateFileRelativeDir;
    }

    public String getTemplateFileName() {
        return templateFileName;
    }
}
