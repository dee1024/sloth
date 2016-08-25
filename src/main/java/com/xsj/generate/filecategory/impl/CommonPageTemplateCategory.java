package com.xsj.generate.filecategory.impl;

import com.xsj.generate.strategy.impl.EnableGeneratedFile;
import com.xsj.generate.filecategory.EnableGeneratedPageTemplate;
import com.xsj.parameter.TargetProjectParameters;

/**
 * 公共页面模版类别
 * Created by dee on 16/6/16.
 */
@Deprecated
public enum CommonPageTemplateCategory implements EnableGeneratedPageTemplate {

    INDEX_HTML(
            "demo.html",
            "/static/html/",
            "demo.html.ftl",
            "/template/common/pagetemplate/static/html/"
    ),
    DEMO_JS(
            "demo.js",
            "/static/js/",
            "demo.js.ftl",
            "/template/common/pagetemplate/static/js/"
    ),
    DEMO_CSS(
            "demo.css",
            "/static/css/",
            "demo.css.ftl",
            "/template/common/pagetemplate/static/css/"
    ),

    INDEX_FTL(
            "index.ftl",
            "/template/",
            "index.ftl.ftl",
            "/template/common/pagetemplate/"
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
    private CommonPageTemplateCategory(String targetFileName, String targetFileRelativeDir, String templateFileName, String templateFileRelativeDir) {
        this.targetFileName = targetFileName;
        this.targetFileRelativeDir = targetFileRelativeDir;
        this.templateFileRelativeDir = templateFileRelativeDir;
        this.templateFileName = templateFileName;
    }

    public static EnableGeneratedFile[] getSelfAll()  {
        int length = CommonPageTemplateCategory.values().length;
        EnableGeneratedFile[] enableGeneratedFiles = new EnableGeneratedFile[length];
        for (int i = 0; i < length; i++) {
            enableGeneratedFiles[i] = CommonPageTemplateCategory.values()[i];
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
