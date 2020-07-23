package com.sdgc.demo.plugin.extension;

public interface PreAndPostExtension extends Extension {

    /**
     * 前置处理
     *
     * @param params        参数
     * @param processRecord 处理对象传递
     */
    void beforeProcess(String params, StringBuilder processRecord);

    /**
     * 后置处理
     *
     * @param params        参数
     * @param processRecord 处理对象传递
     */
    void afterProcess(String params, StringBuilder processRecord);
}
