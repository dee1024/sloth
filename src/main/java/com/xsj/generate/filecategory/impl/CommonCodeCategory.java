package com.xsj.generate.filecategory.impl;

import com.xsj.generate.filecategory.EnableGeneratedCode;
import com.xsj.generate.strategy.impl.EnableGeneratedFile;
import com.xsj.parameter.TargetProjectParameters;

/**
 * 公共的代码类别
 * Created by dee on 16/6/16.
 */
@Deprecated
public enum CommonCodeCategory implements EnableGeneratedCode {

    INDEX_CONTROLLER(
            "IndexController.java",
            "controller/",
            "indexController.ftl",
            "/template/common/"
    ),

    DB(
            "DB.java",
            "config/database/",
            "db.ftl",
            "/template/common/"
    ),

    DB_CONFIG(
            "DBConfig.java",
            "config/database/",
            "dbconfig.ftl",
            "/template/common/"
    ),

    SWAGGER_CONFIG(
            "SwaggerConfig.java",
            "/config/swagger/",
            "swaggerConfig.ftl",
            "/template/common/"
    ),

    REDIS_CONFIG(
            "RedisConfig.java",
            "config/redis/",
            "redisconfig.ftl",
            "/template/common/"
    ),

    APPLICATION(
            "Application.java",
            "",
            "application.ftl",
            "/template/common/"
    ),

    MODEL_PAGE(
            "Page.java",
            "/common/",
            "page.java.ftl",
            "/template/common/"
    ),

    LOG_ASPECT(
            "LogAspect.java",
            "/aop/",
            "LogAspect.java.ftl",
            "/template/common/"
    ),

    ;

    /**
     * @param templateFileRelativeDir 模版相对地址 ( 相对于 classpath 目录, 必须以 "/" 开头)
     * @param templateFileName        模版名字
     * @param targetFileRelativeDir   目标文件保存的相对径目录
     * @param targetFileName          目标文件名字
     */
    private CommonCodeCategory(String targetFileName, String targetFileRelativeDir, String templateFileName, String templateFileRelativeDir) {
        this.targetFileName = targetFileName;
        this.targetFileRelativeDir = targetFileRelativeDir;
        this.templateFileRelativeDir = templateFileRelativeDir;
        this.templateFileName = templateFileName;
    }

    public static EnableGeneratedFile[] getSelfAll()  {
        int length = CommonCodeCategory.values().length;
        EnableGeneratedFile[] enableGeneratedFiles = new EnableGeneratedFile[length];
        for (int i = 0; i < length; i++) {
            enableGeneratedFiles[i] = CommonCodeCategory.values()[i];
        }
        return enableGeneratedFiles;
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
        return TargetProjectParameters.getTargetProjectJavaWhitPackNameStorePath();
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
