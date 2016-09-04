package com.sloth.generate.strategy.impl.support;

/**
 * 生成策略类别
 * Created by sloth on 16/6/24.
 */
public enum GeneratorStrategyCategory {

    //Spring+SpringMVC+MyBatis
    SSM("ssm"),

    //Spring+SpringMVC+Jooq
    SSJ("ssj"),

    //Spring+SpringMVC+SpringJdbcTemplate
    SSS("sss"),

    //JFinal Framework
    JFINAL("jfinal"),

    //Play Framework
    PLAY("play"),
    ;

    public String value;

    private GeneratorStrategyCategory(String value){
        this.value = value;
    }

}
