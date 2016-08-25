package com.xsj.parameter;

import java.io.File;

/**
 * 目标项目所用参数
 * Created by dee on 16/6/16.
 */
public abstract class TargetProjectParameters {

    // TARGET INFO 缺省参数
    protected static String targetsDirectory = System.getProperty("user.dir") + "/target/";
    protected static String targetsName = "generated-sources-by-rkiller";
    protected static String targetPackage = "com.rkiller.generated";
    protected static String encoding = "UTF-8";


    //TODO  对includes, excludes, includeExcludeColumns的支持

    //目录接口与Maven约定格式统一

    //xxxxx/target/DefauleProjectByRK/
    private static String targetProjectStorePath = targetsDirectory + targetsName + "/";

    //xxxxx/target/DefauleProjectByRK/src/main/java/
    private static String targetProjectJavaStorePath = targetProjectStorePath + "src/main/java/";

    //xxxxx/target/DefauleProjectByRK/src/main/java/com.xsj/src/main/resources/
    private static String targetProjectResourceStorePath = targetProjectStorePath + "src/main/resources/";
    private static String targetProjectStaticResourceStorePath = targetProjectStorePath + "src/main/resources/static/";


    //xxxxx/target/DefauleProjectByRK/src/main/java/com.xsj/src/main/assembly/
    private static String targetProjectMavenAssemblyStorePath = targetProjectStorePath + "src/main/assembly/";

    //xxxxx/target/DefauleProjectByRK/src/main/java/com/xsj/
    private static String targetProjectJavaWhitPackNameStorePath = targetProjectJavaStorePath + targetPackage.replace(".", "/") + "/";


    public static void init() {
        if (UserInputParamters.getStorePathInUserParam() != null)
            setTargetsDirectory(UserInputParamters.getStorePathInUserParam());
        if (UserInputParamters.getPackageNameInUserParam() != null)
            setTargetPackage(UserInputParamters.getPackageNameInUserParam());
        if (UserInputParamters.getProjectNameInUserParam() != null)
            setTargetsName(UserInputParamters.getProjectNameInUserParam());

        targetProjectStorePath = targetsDirectory + targetsName + "/";
        targetProjectJavaStorePath = targetProjectStorePath + "src/main/java/";
        targetProjectJavaWhitPackNameStorePath = targetProjectJavaStorePath + targetPackage.replace(".", "/") + "/";
        targetProjectResourceStorePath = targetProjectStorePath + "src/main/resources/";
        targetProjectStaticResourceStorePath = targetProjectStorePath + "src/main/resources/static/";
        targetProjectMavenAssemblyStorePath = targetProjectStorePath + "src/main/assembly/";
    }

    public static String getTargetsDirectory() {
        return targetsDirectory;
    }

    public static void setTargetsDirectory(String targetsDirectory) {
        TargetProjectParameters.targetsDirectory = targetsDirectory;
    }

    public static String getTargetsName() {
        return targetsName;
    }

    public static void setTargetsName(String targetsName) {
        TargetProjectParameters.targetsName = targetsName;
    }

    public static String getTargetPackage() {
        return targetPackage;
    }

    public static void setTargetPackage(String targetPackage) {
        TargetProjectParameters.targetPackage = targetPackage;
    }

    public static String getTargetProjectStorePath() {
        return targetProjectStorePath;
    }

    public static String getTargetProjectJavaStorePath() {
        return targetProjectJavaStorePath;
    }

    public static String getTargetProjectJavaWhitPackNameStorePath() {
        return targetProjectJavaWhitPackNameStorePath;
    }

    public static String getTargetProjectResourceStorePath() {
        return targetProjectResourceStorePath;
    }

    public static String getTargetProjectMavenAssemblyStorePath() {
        return targetProjectMavenAssemblyStorePath;
    }

    public static String getTargetProjectStaticResourceStorePath() {
        return targetProjectStaticResourceStorePath;
    }

    public static String getTargetPackagePath() {
        return getTargetPackage().replace(".", File.separator) + File.separator;
    }


    public static void setTargetProjectStaticResourceStorePath(String targetProjectStaticResourceStorePath) {
        TargetProjectParameters.targetProjectStaticResourceStorePath = targetProjectStaticResourceStorePath;
    }
}