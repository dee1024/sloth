package com.github.coolcooldee.sloth.parameter;

import com.github.coolcooldee.sloth.Application;
import com.github.coolcooldee.sloth.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * resolution the parameters in java -jar
 * TODO Consider using args4j
 * Created by sloth on 16/6/16.
 */
public abstract class UserInputParamters {

    static Logger logger = LoggerFactory.getLogger(UserInputParamters.class);

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

    public static String[] genInputArgs(String path, String projectname, String dbHost, String dbPort, String dbUser, String dbPassword, String dbName, String strategy, String packageName){
        String str = "-path$1 -projectname$2 -h$3 -P$4 -u$5 -p$6 -d$7 -strategy$8 -package$9";
        str = str.replace("$1",path).replace("$2",projectname).replace("$3",dbHost).replace("$4", dbPort)
                .replace("$5",dbUser).replace("$6",dbPassword).replace("$7",dbName).replace("$8",strategy)
                .replace("$9",packageName);
        return str.split(" ");
    }

    public static int init(String[] inputArgs) {
        if (inputArgs != null) {
            for (int i = 0; i < inputArgs.length; i++) {
                String temp = inputArgs[i];
                if (StringUtil.isEmpty(temp))
                    continue;

                if (temp.startsWith("-path")) {
                    setStorePathInUserParam(inputArgs[i].replace("-path", ""));
                    if (!getStorePathInUserParam().endsWith(File.pathSeparator)) {
                        setStorePathInUserParam(getStorePathInUserParam() + File.separator);
                    }
                }else if (temp.startsWith("-rollback")) {
                    setRollbackVersionParam(inputArgs[i].replace("-package", ""));
                }else if (temp.startsWith("-package")) {
                    setPackageNameInUserParam(inputArgs[i].replace("-package", ""));
                }else if (temp.startsWith("-strategy")) {
                    setStrategy4genParam(inputArgs[i].replace("-strategy", ""));
                } else if (temp.startsWith("-projectname")) {
                    setProjectNameInUserParam(inputArgs[i].replace("-projectname", ""));
                } else if (temp.startsWith("-help")) {
                    setDbHostInUserParam(inputArgs[i].replace("-help", ""));
                    if ("".equals(DBSourceParameters.getSourceDbHost())) {
                        logger.info("-h\tdb's host.");
                        logger.info("-P\tdb's Port.");
                        logger.info("-u\tdb's username.");
                        logger.info("-p\tdb's password.");
                        logger.info("-d\tdb's schema name.");
                        logger.info("-t\tdb's table name.");
                        logger.info("-strategy\tassign the strategy for generating target project.");
                        logger.info("-path\ttarget project's dir path.");
                        logger.info("-package\ttarget project's package.");
                        logger.info("-projectname\ttarget project's name.");
                        logger.info("-rollback\trollback the target project to previous version.");
                        return -1;
                    }
                } else if (temp.startsWith("-h")) {
                    setDbHostInUserParam(inputArgs[i].replace("-h", ""));
                }else if (temp.startsWith("-P")) {
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
