package com.xsj.parameter;

import com.xsj.generate.strategy.impl.support.TemplateParameterInfo;

/**
 * 模版配置
 * Created by dee on 16/6/16.
 */
public abstract class TemplateParameters {

    private static TemplateParameterInfo templateParameterInfo = new TemplateParameterInfo();
    private static boolean inited = false;

    public static void init(){
        //Assemble DATA
        templateParameterInfo.setPackageName(TargetProjectParameters.getTargetPackage());
        templateParameterInfo.setProjectName(TargetProjectParameters.getTargetsName());
        templateParameterInfo.setSourceDbHost(DBSourceParameters.getSourceDbHost());
        templateParameterInfo.setSourceDbPassword(DBSourceParameters.getSourceDbPassword());
        templateParameterInfo.setSourceDbPort(DBSourceParameters.getSourceDbPort());
        templateParameterInfo.setSourceDbSchema(DBSourceParameters.getSourceDbSchema());
        templateParameterInfo.setSourceDbUsername(DBSourceParameters.getSourceDbUsername());
        inited = true;
    }

    public static TemplateParameterInfo getTemplateParameterInfo() {
        return templateParameterInfo;
    }
}
