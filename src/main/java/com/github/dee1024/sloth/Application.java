package com.github.dee1024.sloth;

import com.github.dee1024.sloth.generate.Generator;
import com.github.dee1024.sloth.parameter.UserInputParamters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dee1024
 * @link https://github.com/dee1024/code-generator
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
            String projectName = "slothdemo";
            String dbHost = "59.37.172.51";
            String dbPort = "3306";
            String dbUser = "root";
            String dbPassword = "WJCLZVcubGYpipA0";
            String dbName = "slothdemo";
            String strategy = "ssm";
            String packageName = "com.dee1024";
            //generating
            Generator.execute(UserInputParamters.genInputArgs(path,projectName,dbHost,dbPort,dbUser,dbPassword,dbName,strategy,packageName));
        }else{
            //generating
            Generator.execute(args);
        }
    }
}
