package com.github.dee1024.sloth.generate.strategy.impl.support;

/**
 * Created by sloth on 16/6/27.
 */
public class TemplateParameterInfo {

    String projectName;
    String packageName;
    String sourceDbHost;
    String sourceDbPort;
    String sourceDbSchema;
    String sourceDbUsername;
    String sourceDbPassword;
    String allTablesName; //获取所有表的名字,多个用逗号隔开(如: game, gameRole)
    /**
     *  model name, e.g : user、order
     */
    String modelName;
    /**
     *  class name
     *  如: user、userService、userController
     */
    String className;

    public String getSourceDbPassword() {
        return sourceDbPassword;
    }

    public void setSourceDbPassword(String sourceDbPassword) {
        this.sourceDbPassword = sourceDbPassword;
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

    public String getSourceDbHost() {
        return sourceDbHost;
    }

    public void setSourceDbHost(String sourceDbHost) {
        this.sourceDbHost = sourceDbHost;
    }

    public String getSourceDbPort() {
        return sourceDbPort;
    }

    public void setSourceDbPort(String sourceDbPort) {
        this.sourceDbPort = sourceDbPort;
    }

    public String getSourceDbSchema() {
        return sourceDbSchema;
    }

    public void setSourceDbSchema(String sourceDbSchema) {
        this.sourceDbSchema = sourceDbSchema;
    }

    public String getSourceDbUsername() {
        return sourceDbUsername;
    }

    public void setSourceDbUsername(String sourceDbUsername) {
        this.sourceDbUsername = sourceDbUsername;
    }

    public String getClassName() {
        return className;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAllTablesName() {
        return allTablesName;
    }

    public void setAllTablesName(String allTablesName) {
        this.allTablesName = allTablesName;
    }
}
