package com.github.dee1024.sloth.parameter;

import com.github.dee1024.sloth.utils.StringUtil;

/**
 * Setting database parameters
 * Created by sloth on 16/6/16.
 */
public abstract class DBSourceParameters {

    //SOURCE INFO
    private static String sourceDbHost = "127.0.0.1";
    private static String sourceDbPort = "3306";
    private static String sourceDbSchema = "test";
    private static String sourceDbUsername = "root";
    private static String sourceDbPassword = "";

    public static void inti(){
        if(!StringUtil.isEmpty(UserInputParamters.getDbHostInUserParam()))
            setSourceDbHost(UserInputParamters.getDbHostInUserParam());
        if(!StringUtil.isEmpty(UserInputParamters.getDbPortInUserParam()))
            setSourceDbPort(UserInputParamters.getDbPortInUserParam());
        if(!StringUtil.isEmpty(UserInputParamters.getDbUserNameInUserParam()))
            setSourceDbUsername(UserInputParamters.getDbUserNameInUserParam());
        if(!StringUtil.isEmpty(UserInputParamters.getDbPasswordInUserParam()))
            setSourceDbPassword(UserInputParamters.getDbPasswordInUserParam());
        if(!StringUtil.isEmpty(UserInputParamters.getDbSchemaInUserParam()))
            setSourceDbSchema(UserInputParamters.getDbSchemaInUserParam());
    }

    public static String getSourceDbHost() {
        return sourceDbHost;
    }

    public static void setSourceDbHost(String sourceDbHost) {
        DBSourceParameters.sourceDbHost = sourceDbHost;
    }

    public static String getSourceDbPort() {
        return sourceDbPort;
    }

    public static void setSourceDbPort(String sourceDbPort) {
        DBSourceParameters.sourceDbPort = sourceDbPort;
    }

    public static String getSourceDbSchema() {
        return sourceDbSchema;
    }

    public static void setSourceDbSchema(String sourceDbSchema) {
        DBSourceParameters.sourceDbSchema = sourceDbSchema;
    }

    public static String getSourceDbUsername() {
        return sourceDbUsername;
    }

    public static void setSourceDbUsername(String sourceDbUsername) {
        DBSourceParameters.sourceDbUsername = sourceDbUsername;
    }

    public static String getSourceDbPassword() {
        return sourceDbPassword;
    }

    public static void setSourceDbPassword(String sourceDbPassword) {
        DBSourceParameters.sourceDbPassword = sourceDbPassword;
    }


}
