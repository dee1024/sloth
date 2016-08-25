package com.xsj.parameter;

import com.xsj.generate.strategy.GeneratorStrategy;
import com.xsj.generate.strategy.impl.SSM.SSMGeneratorStrategy;

/**
 * 生成策略所用参数
 * Created by dee on 16/6/26.
 */
public abstract class GeneratorSteategyParameters {
    /**
     * 默认策略
     */
    final static GeneratorStrategy defaultGeneratorStrategy = new SSMGeneratorStrategy();

    /**
     * 指定策略
     */
    static GeneratorStrategy generatorStrategy;

    public static void init(){
        GeneratorStrategy generatorStrategy = GeneratorStrategy.getInstance(UserInputParamters.getStrategy4genParam());
        if(generatorStrategy!=null)
            setGeneratorStrategy(generatorStrategy);
    }

    public static GeneratorStrategy getGeneratorStrategy() {
        if (generatorStrategy==null)
            return defaultGeneratorStrategy;
        return generatorStrategy;
    }

    public static void setGeneratorStrategy(GeneratorStrategy generatorStrategy) {
        GeneratorSteategyParameters.generatorStrategy = generatorStrategy;
    }
}
