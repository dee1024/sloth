package com.github.coolcooldee.sloth.parameter;

import com.github.coolcooldee.sloth.utils.DirectoryUtil;

import java.io.File;

/**
 *
 * Created by sloth on 16/7/3.
 */
public abstract class SourceProjectPathParamters {

    /**
     *
     */
    static String sourceProjectClassPath = (System.getProperty("user.dir")+"/target/classes/").replace("/", File.separator);

    static String sourceProjectStaticFilePath = (sourceProjectClassPath+"template/common/src/main/resources/static/").replace("/", File.separator);

    public static String getSourceProjectClassPath() {
        return sourceProjectClassPath;
    }

    public static void setSourceProjectClassPath(String sourceProjectClassPath) {
        SourceProjectPathParamters.sourceProjectClassPath = sourceProjectClassPath;
    }

    public static String getSourceProjectStaticFilePath() {
        return sourceProjectStaticFilePath;
    }

    public static void setSourceProjectStaticFilePath(String sourceProjectStaticFilePath) {
        SourceProjectPathParamters.sourceProjectStaticFilePath = sourceProjectStaticFilePath;
    }

    public static void main(String[] args) {
        DirectoryUtil.readFile(sourceProjectStaticFilePath);
    }

}
