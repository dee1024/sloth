package com.dee.parameter;

import com.dee.utils.StringUtil;

import java.io.File;

/**
 * resolution the parameters in java -jar
 * TODO Consider using args4j
 * Created by dee on 16/6/16.
 */
public abstract class UserInputParamters {

    private static String storePathInUserParam;
    private static String packageNameInUserParam;
    private static String projectNameInUserParam;

    private static String dbHostInUserParam;
    private static String dbPortInUserParam;
    private static String dbUserNameInUserParam;
    private static String dbPasswordInUserParam;
    private static String dbSchemaInUserParam;
    private static String dbTableInUserParam;

    private static String strategy4genParam;

    private static String rollbackVersionParam = "";

    public static int init(String[] inputArgs) {
        if (inputArgs != null) {
            for (int i = 0; i < inputArgs.length; i++) {
                String temp = inputArgs[i];
                if (StringUtil.isEmpty(temp))
                    continue;

                if (temp.startsWith("-path")) {
                    setStorePathInUserParam(inputArgs[i].replace("-path", ""));
                    if (!getStorePathInUserParam().endsWith(File.pathSeparator)) {
                        setStorePathInUserParam(getStorePathInUserParam() + "/");
                    }
                }else if (temp.startsWith("-rollback")) {
                    setRollbackVersionParam(inputArgs[i].replace("-package", ""));
                }else if (temp.startsWith("-package")) {
                    setPackageNameInUserParam(inputArgs[i].replace("-package", ""));
                }else if (temp.startsWith("-strategy")) {
                    setStrategy4genParam(inputArgs[i].replace("-strategy", ""));
                } else if (temp.startsWith("-projectname")) {
                    setProjectNameInUserParam(inputArgs[i].replace("-projectname", ""));
                } else if (temp.startsWith("-h")) {
                    setDbHostInUserParam(inputArgs[i].replace("-h", ""));
                    if ("".equals(DBSourceParameters.getSourceDbHost())) {
                        System.out.println("-h\tdb's host.");
                        System.out.println("-P\tdb's Port.");
                        System.out.println("-u\tdb's username.");
                        System.out.println("-p\tdb's password.");
                        System.out.println("-d\tdb's schema name.");
                        System.out.println("-t\tdb's table name.");
                        System.out.println("-strategy\tassign the strategy for generating target project.");
                        System.out.println("-path\ttarget project's dir path.");
                        System.out.println("-package\ttarget project's package.");
                        System.out.println("-projectname\ttarget project's name.");
                        System.out.println("-rollback\trollback the target project to previous version.");
                        return -1;
                    }
                } else if (temp.startsWith("-P")) {
                    setDbPortInUserParam(inputArgs[i].replace("-P", ""));
                } else if (temp.startsWith("-u")) {
                    setDbUserNameInUserParam(inputArgs[i].replace("-u", ""));
                } else if (temp.startsWith("-p")) {
                    setDbPasswordInUserParam(inputArgs[i].replace("-p", ""));
                } else if (temp.startsWith("-d")) {
                    setDbSchemaInUserParam(inputArgs[i].replace("-d", ""));
                }else if (temp.startsWith("-t")) {
                    setDbTableInUserParam(inputArgs[i].replace("-t", ""));
                }
            }
            return 1;
        }
        return 1;
    }

    public static String getStorePathInUserParam() {
        return storePathInUserParam;
    }

    public static void setStorePathInUserParam(String storePathInUserParam) {
        UserInputParamters.storePathInUserParam = storePathInUserParam;
    }

    public static String getPackageNameInUserParam() {
        return packageNameInUserParam;
    }

    public static void setPackageNameInUserParam(String packageNameInUserParam) {
        UserInputParamters.packageNameInUserParam = packageNameInUserParam;
    }

    public static String getProjectNameInUserParam() {
        return projectNameInUserParam;
    }

    public static void setProjectNameInUserParam(String projectNameInUserParam) {
        UserInputParamters.projectNameInUserParam = projectNameInUserParam;
    }

    public static String getDbHostInUserParam() {
        return dbHostInUserParam;
    }

    public static void setDbHostInUserParam(String dbHostInUserParam) {
        UserInputParamters.dbHostInUserParam = dbHostInUserParam;
    }

    public static String getDbPortInUserParam() {
        return dbPortInUserParam;
    }

    public static void setDbPortInUserParam(String dbPortInUserParam) {
        UserInputParamters.dbPortInUserParam = dbPortInUserParam;
    }

    public static String getDbUserNameInUserParam() {
        return dbUserNameInUserParam;
    }

    public static void setDbUserNameInUserParam(String dbUserNameInUserParam) {
        UserInputParamters.dbUserNameInUserParam = dbUserNameInUserParam;
    }

    public static String getDbPasswordInUserParam() {
        return dbPasswordInUserParam;
    }

    public static void setDbPasswordInUserParam(String dbPasswordInUserParam) {
        UserInputParamters.dbPasswordInUserParam = dbPasswordInUserParam;
    }

    public static String getDbSchemaInUserParam() {
        return dbSchemaInUserParam;
    }

    public static void setDbSchemaInUserParam(String dbSchemaInUserParam) {
        UserInputParamters.dbSchemaInUserParam = dbSchemaInUserParam;
    }

    public static String getStrategy4genParam() {
        return strategy4genParam;
    }

    public static void setStrategy4genParam(String strategy4genParam) {
        UserInputParamters.strategy4genParam = strategy4genParam;
    }

    public static String getDbTableInUserParam() {
        return dbTableInUserParam;
    }

    public static void setDbTableInUserParam(String dbTableInUserParam) {
        UserInputParamters.dbTableInUserParam = dbTableInUserParam;
    }

    public static String getRollbackVersionParam() {
        return rollbackVersionParam;
    }

    public static void setRollbackVersionParam(String rollbackVersionParam) {
        UserInputParamters.rollbackVersionParam = rollbackVersionParam;
    }
}
