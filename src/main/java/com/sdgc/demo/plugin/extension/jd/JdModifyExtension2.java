package com.sdgc.demo.plugin.extension.jd;

import com.sdgc.demo.plugin.extension.ModifyExtension2;

public class JdModifyExtension2 implements ModifyExtension2 {

    @Override
    public void modify(String params, StringBuilder processRecord) {
        System.out.println("京东活动优化处理流程2");
        processRecord.append("京东活动优化处理流程2 - ");
    }
}
