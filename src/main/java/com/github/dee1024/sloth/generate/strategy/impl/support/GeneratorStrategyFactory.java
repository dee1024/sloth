package com.github.dee1024.sloth.generate.strategy.impl.support;

import com.github.dee1024.sloth.generate.strategy.AbstractGeneratorStrategy;
import com.github.dee1024.sloth.generate.strategy.GeneratorStrategy;
import com.github.dee1024.sloth.parameter.EnableSupportUserInputPatamter;
import com.github.dee1024.sloth.utils.ClassUtil;
import com.github.dee1024.sloth.utils.StringUtil;

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
