package com.github.coolcooldee.sloth.generate.strategy.impl.ssj;

import com.github.coolcooldee.sloth.generate.strategy.AbstractGeneratorStrategy;
import com.github.coolcooldee.sloth.generate.strategy.impl.support.GeneratorStrategyCategory;

/**
 * Created by sloth on 16/6/26.
 */
public class SSJGeneratorStrategy extends AbstractGeneratorStrategy {

    @Override
    public String getSpecifiedStr() {
        return GeneratorStrategyCategory.SSJ.value;
    }

    @Override
    protected boolean ignoreDefaultDBCode() {
        return false;
    }

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
