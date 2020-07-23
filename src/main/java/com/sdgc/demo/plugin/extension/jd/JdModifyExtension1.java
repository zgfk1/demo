package com.sdgc.demo.plugin.extension.jd;

import com.sdgc.demo.plugin.extension.ModifyExtension1;

public class JdModifyExtension1 implements ModifyExtension1 {

    @Override
    public void modify(String params, StringBuilder processRecord) {
        System.out.println("京东活动优化处理流程1");
        processRecord.append("京东活动优化处理流程1 - ");
    }
}