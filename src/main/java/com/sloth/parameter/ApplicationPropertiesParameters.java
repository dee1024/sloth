package com.sloth.parameter;

/**
 * Created by sloth on 16/7/2.
 */
public class ApplicationPropertiesParameters {

    private String dbHost;

    private int dbPort;

    private String dbUser;

    private String dbPassword;

    private String dbName;

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDBHost() {
        return dbHost;
    }

    public int getDBPort() {
        return dbPort;
    }

    public String getDBUser() {
        return dbUser;
    }

    public String getDBPassword() {
        return dbPassword;
    }

    public String getDBName() {
        return dbName;
    }

}
