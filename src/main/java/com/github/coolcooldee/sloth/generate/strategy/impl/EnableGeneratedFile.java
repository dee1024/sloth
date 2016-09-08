package com.github.coolcooldee.sloth.generate.strategy.impl;


/**
 * Created by sloth on 16/6/16.
 */
public interface EnableGeneratedFile {

    /**
     * Target File Name (e.g : pom.xml、mvn.sh、${model}Service.java、DB.java, especially, "${model}" will be replaced by actual model name.
     * @return
     */
    String getTargetFileName();

    String getTargetFileAbsoluteBaseDir();


    String getTargetFileRelativeDir();


    String getTemplateFileRelativeDir();


    String getTemplateFileName();


    String getOriginalModelName(String originalModelName);

}
