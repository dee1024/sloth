package com.github.coolcooldee.sloth.parameter;

import com.github.coolcooldee.sloth.generate.strategy.impl.support.TemplateParameterInfo;

/**
 * Setting template parameters
 * Created by sloth on 16/6/16.
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
