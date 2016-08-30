package com.dee.generate.strategy.impl.play;

import com.dee.generate.strategy.impl.EnableGeneratedFile;

/**
 * Created by dee on 16/6/28.
 */
public enum PLAYCodeCategory implements EnableGeneratedFile {

    MODEL(
            "*.java",
            "model/",
            "model.ftl",
            "/template/play/"
    ),
    ;


    /**
     * @param templateFileRelativeDir 模版相对地址 ( 相对于 classpath 目录, 必须以 "/" 开头)
     * @param templateFileName 模版名字
     * @param targetFileRelativeDir 目标文件保存的相对路径目录 ( 相对于项目包下面,如 com.dee )
     * @param targetFileName 目标文件名字
     */
    private PLAYCodeCategory(String targetFileName, String targetFileRelativeDir, String templateFileName, String templateFileRelativeDir){
        this.targetFileName = targetFileName;
        this.targetFileRelativeDir = targetFileRelativeDir;
        this.templateFileRelativeDir = templateFileRelativeDir;
        this.templateFileName = templateFileName;
    }

    private String targetFileName;

    private String targetFileRelativeDir;

    private String templateFileRelativeDir;

    private String templateFileName;

    @Override
    public String getOriginalModelName(String originalModelName) {
        return originalModelName;
    }

    @Override
    public String getTargetFileName() {
        return targetFileName;
    }

    public String getTargetFileAbsoluteBaseDir() {
        return null;
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
