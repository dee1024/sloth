package com.github.dee1024.sloth.generate.strategy.impl.ssd;

import com.github.dee1024.sloth.generate.strategy.AbstractGeneratorStrategy;
import com.github.dee1024.sloth.generate.strategy.impl.support.GeneratorStrategyCategory;

/**
 *
 * generate Spring + SpringMVC + SpringData frameword scaffold
 * Created by sloth on 16/9/10.
 *
 */
public class SSDGeneratorStrategy extends AbstractGeneratorStrategy {

    @Override
    public String getSpecifiedStr() {
        return GeneratorStrategyCategory.SSD.value;
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
