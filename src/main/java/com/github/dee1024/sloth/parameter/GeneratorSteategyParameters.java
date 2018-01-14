package com.github.dee1024.sloth.parameter;

import com.github.dee1024.sloth.generate.strategy.impl.ssm.SSMGeneratorStrategy;
import com.github.dee1024.sloth.generate.strategy.GeneratorStrategy;
import com.github.dee1024.sloth.generate.strategy.impl.support.GeneratorStrategyFactory;

/**
 * Setting steategy parameters
 * Created by sloth on 16/6/26.
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
        GeneratorStrategy generatorStrategy = GeneratorStrategyFactory.getInstance(UserInputParamters.getStrategy4genParam());
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
