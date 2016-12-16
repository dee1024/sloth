package com.github.coolcooldee.sloth.generate.strategy.impl.support;

import com.github.coolcooldee.sloth.generate.strategy.AbstractGeneratorStrategy;
import com.github.coolcooldee.sloth.generate.strategy.GeneratorStrategy;
import com.github.coolcooldee.sloth.parameter.EnableSupportUserInputPatamter;
import com.github.coolcooldee.sloth.utils.ClassUtil;
import com.github.coolcooldee.sloth.utils.StringUtil;

import java.util.List;

/**
 * Created by dee on 2016/12/16.
 */
public abstract class GeneratorStrategyFactory {

    public static GeneratorStrategy getInstance(String s){

        if(StringUtil.isEmpty(s))
            return  null;

        List<Class<?>> list = ClassUtil.getAllAssignedClass(AbstractGeneratorStrategy.class);
        for(Class<?> ec : list){
            try {
                EnableSupportUserInputPatamter esu =  (EnableSupportUserInputPatamter)ec.newInstance();
                if(s.equals(esu.getSpecifiedStr())){
                    return (GeneratorStrategy)esu;
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
