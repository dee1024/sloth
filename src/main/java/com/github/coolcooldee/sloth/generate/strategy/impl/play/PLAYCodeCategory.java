package com.github.coolcooldee.sloth.generate.strategy.impl.play;

import com.github.coolcooldee.sloth.generate.strategy.impl.EnableGeneratedFile;

/**
 * Created by sloth on 16/6/28.
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
     * @param templateFileRelativeDir relative to the "classpath" directory , start with "/"
     * @param templateFileName
     * @param targetFileRelativeDir relative to the packageName directory , e.g com.github.coolcooldee.sloth )
     * @param targetFileName
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
