package com.sdgc.demo.plugin.extension;

public interface ModifyExtension2 extends Extension {

    /**
     * @param params        参数
     * @param processRecord 处理对象传递
     */
    void modify(String params, StringBuilder processRecord);

}