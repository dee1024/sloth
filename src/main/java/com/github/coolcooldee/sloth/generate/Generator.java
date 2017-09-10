package com.github.coolcooldee.sloth.generate;

import com.github.coolcooldee.sloth.Application;
import com.github.coolcooldee.sloth.parameter.*;

import com.github.coolcooldee.sloth.utils.DirectoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Generator {

    static Logger logger = LoggerFactory.getLogger(Generator.class);

    public static void execute(String[] args) throws Exception{

        // Step 1
        UserInputParamters.init(args);
        // Step 1.1
        DBSourceParameters.inti();
        // Step 1.2
        TargetProjectParameters.init();
        // Step 1.3
        TemplateParameters.init();
        // Step 1.4
        GeneratorSteategyParameters.init();
        // Step 2
        GeneratorSteategyParameters.getGeneratorStrategy().execute();
        // Step 3
        printlnResult();
    }

    private static void printlnResult(){
        logger.info("\nTarget project directory is : " + TargetProjectParameters.getTargetProjectStorePath());
        DirectoryUtil.readFile(TargetProjectParameters.getTargetProjectStorePath());
        logger.info("\n\n");
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        logger.info("@      Genarate Successfully !       @");
        logger.info("@   Thank you for using sloth "+ Application.version_desc+"    @");
        logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

}
