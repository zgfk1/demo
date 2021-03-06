package com.sdgc.demo.plugin.extension;

public class TaobaoProcessExtension implements PreAndPostExtension {

    @Override
    public void beforeProcess(String params, StringBuilder processRecord) {
        System.out.println("淘宝活动前置处理流程");
        processRecord.append("淘宝活动前置处理流程 - ");
    }

    @Override
    public void afterProcess(String params, StringBuilder processRecord) {
        System.out.println("淘宝活动后置处理流程");
        processRecord.append("淘宝活动后置处理流程");
    }
}
