package com.github.dee1024.sloth.generate.strategy;

/**
 * Created by sloth on 16/6/26.
 */
public interface GeneratorStrategy {

    boolean isNeedScript = true;

    String encoding = "utf-8";

    void execute();

}
