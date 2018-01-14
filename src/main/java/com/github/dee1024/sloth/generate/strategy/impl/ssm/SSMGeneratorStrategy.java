package com.github.dee1024.sloth.generate.strategy.impl.ssm;
import com.github.dee1024.sloth.generate.strategy.AbstractGeneratorStrategy;
import com.github.dee1024.sloth.generate.strategy.impl.support.GeneratorStrategyCategory;

/**
 *
 * generate Spring+SpringMVC+MyBatis frameword scaffold
 * Created by sloth on 16/6/26.
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
