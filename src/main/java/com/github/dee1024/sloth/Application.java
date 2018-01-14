package com.github.dee1024.sloth;

import com.github.dee1024.sloth.generate.Generator;
import com.github.dee1024.sloth.parameter.UserInputParamters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dee1024
 * @link https://github.com/dee1024/sloth
 * @since 16/6/16
 *
 */
public class Application {

    public final static String version_desc = "v1.0";

    static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        if(args==null || args.length==0) {
            //setting demo paramters
            String path = "/Users/dee/Documents/dev/workspace";
            String projectName = "test";
            String dbHost = "127.0.0.1";
            String dbPort = "3306";
            String dbUser = "root";
            String dbPassword = "";
            String dbName = "test";
            String strategy = "ssm";
            String packageName = "com.dee.test";
            //generating
            Generator.execute(UserInputParamters.genInputArgs(path,projectName,dbHost,dbPort,dbUser,dbPassword,dbName,strategy,packageName));
        }else{
            //generating
            Generator.execute(args);
        }
    }
}
