package com.xsj.generate.strategy.impl.play;

import com.xsj.generate.strategy.AbstractGeneratorStrategy;

/**
 * Created by dee on 16/6/28.
 */
public class PLAYGeneratorStrategy extends AbstractGeneratorStrategy {

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

    @Override
    public String getSpecifiedStr() {
        return null;
    }
}
