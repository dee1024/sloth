package com.xsj.parameter;

import com.xsj.generate.strategy.GeneratorStrategy;
import com.xsj.generate.strategy.impl.ssm.SSMGeneratorStrategy;

/**
 * Setting steategy parameters
 * Created by dee on 16/6/26.
 */
public abstract class GeneratorSteategyParameters {
    /**
     * default steategy
     */
    final static GeneratorStrategy defaultGeneratorStrategy = new SSMGeneratorStrategy();

    /**
     * customized steategy
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
