package com.github.coolcooldee.sloth.parameter;

import java.io.File;

/**
 * setting target project's path parameter
 *
 * Created by sloth on 16/6/16.
 */
public abstract class TargetProjectParameters {

    // TARGET INFO
    protected static String targetsDirectory = (System.getProperty("user.dir") + "/target/").replace("/", File.separator);
    protected static String targetsName = "mySlothProject";
    protected static String targetPackage = "com.sloth.generated";
    protected static String encoding = "UTF-8";


    //TODO  对includes, excludes, includeExcludeColumns的支持


    //xxxxx/target/DefauleProjectByRK/
    private static String targetProjectStorePath = targetsDirectory + targetsName + "/".replace("/", File.separator);

    //xxxxx/target/DefauleProjectByRK/src/main/java/
    private static String targetProjectJavaStorePath = targetProjectStorePath + "src/main/java/".replace("/", File.separator);
    private static String targetProjectTestJavaStorePath = targetProjectStorePath + "src/test/java/".replace("/", File.separator);

    //xxxxx/target/DefauleProjectByRK/src/main/java/com.sloth/src/main/resources/
    private static String targetProjectResourceStorePath = targetProjectStorePath + "src/main/resources/".replace("/", File.separator);
    private static String targetProjectStaticResourceStorePath = targetProjectStorePath + "src/main/resources/static/".replace("/", File.separator);


    //xxxxx/target/DefauleProjectByRK/src/main/java/com.sloth/src/main/assembly/
    private static String targetProjectMavenAssemblyStorePath = targetProjectStorePath + "src/main/assembly/";

    //xxxxx/target/DefauleProjectByRK/src/main/java/com/sloth/
    private static String targetProjectJavaWhitPackNameStorePath = targetProjectJavaStorePath + targetPackage.replace(".", "/") + "/";


    public static void init() {
        if (UserInputParamters.getStorePathInUserParam() != null)
            setTargetsDirectory(UserInputParamters.getStorePathInUserParam());
        if (UserInputParamters.getPackageNameInUserParam() != null)
            setTargetPackage(UserInputParamters.getPackageNameInUserParam());
        if (UserInputParamters.getProjectNameInUserParam() != null)
            setTargetsName(UserInputParamters.getProjectNameInUserParam());

        targetProjectStorePath = (targetsDirectory + targetsName + "/").replace("/", File.separator);
        targetProjectJavaStorePath = (targetProjectStorePath + "src/main/java/").replace("/", File.separator);
        targetProjectTestJavaStorePath = (targetProjectStorePath + "src/test/java/").replace("/", File.separator);
        targetProjectJavaWhitPackNameStorePath = (targetProjectJavaStorePath + targetPackage.replace(".", "/") + "/").replace("/", File.separator);
        targetProjectResourceStorePath = (targetProjectStorePath + "src/main/resources/").replace("/", File.separator);
        targetProjectStaticResourceStorePath = (targetProjectStorePath + "src/main/resources/static/").replace("/", File.separator);
        targetProjectMavenAssemblyStorePath = (targetProjectStorePath + "src/main/assembly/").replace("/", File.separator);
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