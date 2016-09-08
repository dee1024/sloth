package com.github.coolcooldee.sloth.generate.strategy;

import com.github.coolcooldee.sloth.parameter.EnableSupportUserInputPatamter;
import com.github.coolcooldee.sloth.utils.ClassUtil;
import com.github.coolcooldee.sloth.utils.StringUtil;

import java.util.List;

/**
 * Created by sloth on 16/6/26.
 */
public interface GeneratorStrategy {

    boolean isNeedScript = true;

    String encoding = "utf-8";

    void execute();

    static GeneratorStrategy getInstance(String s){

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
