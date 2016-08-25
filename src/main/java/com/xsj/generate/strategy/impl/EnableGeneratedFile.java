package com.xsj.generate.strategy.impl;


/**
 * 可生成文件的接口类
 * Created by dee on 16/6/16.
 */
public interface EnableGeneratedFile {

    /**
     * 目标文件名字 (比如: pom.xml、mvn.sh、*Service.java、DB.java, 特别的, 带有 * 号的表示需要替换成具体的 "模型对象的名字")
     * @return
     */
    String getTargetFileName();

    /**
     * 基础路径, 用于和相对路径结合成目标文件的绝对路径
     * @return
     */
    String getTargetFileAbsoluteBaseDir();

    /**
     * 目标文件保存的相对路径目录(具体使用哪个相对地址, 在生成策略里面)
     * @return
     */
    String getTargetFileRelativeDir();

    /**
     * 模版相对地址 ( 相对于 classpath 目录, 以 "/" 开头和结尾)
     * 如: /template/ssm/
     * @return
     */
    String getTemplateFileRelativeDir();

    /**
     * 模版名字
     * 比如: pom.ftl
     * @return
     */
    String getTemplateFileName();


    /**
     * 对 model名字定制化
     * @param originalModelName
     * @return
     */
    String getOriginalModelName(String originalModelName);

}
