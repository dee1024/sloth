package com.github.coolcooldee.sloth.parameter;
import com.github.coolcooldee.sloth.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chihche on 16/7/12.
 */
public class WebBuildParameters {
    String host;
    String port;
    String username;
    String password;
    String schema;
    String tableName;
    String projectName;
    String packageName;
    String path;
    String strategy;
    String rollback;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getRollback() {
        return rollback;
    }

    public void setRollback(String rollback) {
        this.rollback = rollback;
    }

    public String[] getBuildParams(){
        List<String> stringArray = new ArrayList<String>();
        if (!StringUtil.isEmpty(getHost()))
            stringArray.add("-h"+getHost());
        if (!StringUtil.isEmpty(getPort()))
            stringArray.add("-P"+getPort());
        if (!StringUtil.isEmpty(getUsername()))
            stringArray.add("-u"+getUsername());
        if (!StringUtil.isEmpty(getPassword()))
            stringArray.add("-p"+getPassword());
        if (!StringUtil.isEmpty(getSchema()))
            stringArray.add("-d"+getSchema());
        if (!StringUtil.isEmpty(getTableName()))
            stringArray.add("-t"+getTableName());
        if (!StringUtil.isEmpty(getStrategy()))
            stringArray.add("-strategy"+getStrategy());
        if (!StringUtil.isEmpty(getPath()))
            stringArray.add("-path"+getPath());
        if (!StringUtil.isEmpty(getPackageName()))
            stringArray.add("-package"+getPackageName());
        if (!StringUtil.isEmpty(getProjectName()))
            stringArray.add("-projectname"+getProjectName());
        if (!StringUtil.isEmpty(getRollback()))
            stringArray.add("-rollback"+getRollback());
        return stringArray.toArray(new String[]{});
    }
}
