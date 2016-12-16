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

}
