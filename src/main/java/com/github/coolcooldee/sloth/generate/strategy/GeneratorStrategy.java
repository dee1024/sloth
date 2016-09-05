package com.github.coolcooldee.sloth.generate.strategy;

import com.github.coolcooldee.sloth.parameter.EnableSupportUserInputPatamter;
import com.github.coolcooldee.sloth.utils.ClassUtil;
import com.github.coolcooldee.sloth.utils.StringUtil;

import java.util.List;

/**
 * 生成策略接口类
 * 其中实现了一个方法, 可以传入具体的策略类对应的"字符串标记"(需要实现 EnableSupportUserInputPatamter 接口), 来获得该策略类, 一般用于 "通过用户传入的指令参数来获得对应的策略"
 * Created by sloth on 16/6/26.
 */
public interface GeneratorStrategy {

    boolean isNeedScript = true;

    String encoding = "utf-8";

    /**
     * 使用该策略执行生成
     */
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
