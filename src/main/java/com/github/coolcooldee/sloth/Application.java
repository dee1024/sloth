package com.github.coolcooldee.sloth;

import com.github.coolcooldee.sloth.generate.Generator;
import com.github.coolcooldee.sloth.parameter.UserInputParamters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Dee1024
 * @link https://github.com/coolcooldee/sloth
 * @since 16/6/16
 *
 */
public class Application {

    static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        if(args==null || args.length==0) {
            //setting demo paramters
            String path = "/Users/dee/Documents/dev/workspace";
            String projectName = "gamesapi";
            String dbHost = "127.0.0.1";
            String dbPort = "3306";
            String dbUser = "root";
            String dbPassword = "";
            String dbName = "gamesapi";
            String strategy = "ssd";
            String packageName = "com.github.coolcool.sloth.gamesapi";
            //generating
            Generator.execute(UserInputParamters.genInputArgs(path,projectName,dbHost,dbPort,dbUser,dbPassword,dbName,strategy,packageName));
        }else{
            //generating
            Generator.execute(args);
        }

    }

}
