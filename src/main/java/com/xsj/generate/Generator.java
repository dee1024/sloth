package com.xsj.generate;

import com.xsj.parameter.*;

import com.xsj.utils.DirectoryUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 生成整体流程
 */
public class Generator {

    static Logger logger = LoggerFactory.getLogger(Generator.class);

    public static JSONObject execute(String[] args) throws Exception{

        // Step 1, 解析用户参数
        UserInputParamters.init(args);
        // Step 2, 数据库参数初始化
        DBSourceParameters.inti();
        // Step 3, 目标项目参数初始化
        TargetProjectParameters.init();
        // Step 4, 模版初始化
        TemplateParameters.init();
        // Step 5, 生成策略参数初始化
        GeneratorSteategyParameters.init();
        // Step 6, 执行生成, 核心流程
        GeneratorSteategyParameters.getGeneratorStrategy().execute();
        //Step 7, 输出结果
        String result = getResult();
        System.out.println(result);

        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("msg",result.replace("\n", "<br>"));

        return json;
    }

    private static void printlnResult(){
        System.out.println("Target project directory :" + TargetProjectParameters.getTargetProjectStorePath());
        DirectoryUtil.readFile(TargetProjectParameters.getTargetProjectStorePath());
        System.out.println("\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@      Genarate Successfully !      @");
        System.out.println("@ Thank you for using RKiller 1.0   @");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    private static String getResult(){
        StringBuffer sb = new StringBuffer();
        sb.append("生成地址:" + TargetProjectParameters.getTargetProjectStorePath() + "\n");
        sb.append(DirectoryUtil.readFile2String(TargetProjectParameters.getTargetProjectStorePath()));
        sb.append("\n\n@      Genarate Successfully !      @");
        sb.append("\n@ Thank you for using RKiller 1.0   @");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Generator.execute(args);
    }

}
