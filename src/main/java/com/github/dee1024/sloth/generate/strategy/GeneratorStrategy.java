package com.github.dee1024.sloth.generate.strategy;

import com.github.dee1024.sloth.parameter.EnableSupportUserInputPatamter;
import com.github.dee1024.sloth.utils.ClassUtil;
import com.github.dee1024.sloth.utils.StringUtil;

import java.util.List;

/**
 * Created by sloth on 16/6/26.
 */
public interface GeneratorStrategy {

    boolean isNeedScript = true;

    String encoding = "utf-8";

    void execute();

}
