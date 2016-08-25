package com.xsj.generate.strategy.impl.sss;

import com.xsj.generate.strategy.AbstractGeneratorStrategy;
import com.xsj.generate.strategy.impl.support.GeneratorStrategyCategory;

/**
 *
 * 按照 Spring + SpringMVC + SpringJdbcTemplate 框架生成
 * Created by dee on 16/7/03.
 *
 */
public class SSSGeneratorStrategy extends AbstractGeneratorStrategy {

    @Override
    public String getSpecifiedStr() {
        return GeneratorStrategyCategory.SSS.value;
    }

    @Override
    protected boolean ignoreDefaultDBCode() { return false;}

    @Override
    protected boolean ignoreDefaultApplicationCode() {
        return false;
    }

    @Override
    protected boolean ignoreDefaultResourceFile() {
        return false;
    }

    @Override
    protected boolean ignoreDefaultAssemblyFile() {
        return false;
    }

    @Override
    protected boolean ignoreDefaultShellScriptFiles() {
        return false;
    }

    @Override
    protected boolean ignoreDefaultPomFile() {
        return false;
    }

    @Override
    protected boolean ignoreDefaultIndexControllerCode() {
        return false;
    }

    @Override
    protected boolean ignoreDefaultTemplateFile() {
        return false;
    }

}
