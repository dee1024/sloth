package com.dee.generate.strategy.impl.ssm;
import com.dee.generate.strategy.AbstractGeneratorStrategy;
import com.dee.generate.strategy.impl.support.GeneratorStrategyCategory;

/**
 *
 * generate Spring+SpringMVC+MyBatis frameword scaffold
 * Created by dee on 16/6/26.
 *
 */
public class SSMGeneratorStrategy extends AbstractGeneratorStrategy {

    @Override
    public String getSpecifiedStr() {
        return GeneratorStrategyCategory.SSM.value;
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
