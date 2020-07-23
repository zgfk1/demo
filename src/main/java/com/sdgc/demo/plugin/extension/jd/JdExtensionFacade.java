package com.sdgc.demo.plugin.extension.jd;

import com.sdgc.demo.annotation.BizCode;
import com.sdgc.demo.plugin.extension.ExtensionFacade;
import com.sdgc.demo.plugin.extension.ModifyExtension1;
import com.sdgc.demo.plugin.extension.ModifyExtension2;
import com.sdgc.demo.plugin.extension.PreAndPostExtension;

@BizCode("jd")
public class JdExtensionFacade implements ExtensionFacade {

    @Override
    public PreAndPostExtension getPreAndPostExtension() {
        return new PreAndPostExtension() {
            @Override
            public void beforeProcess(String params, StringBuilder processRecord) {
                System.out.println("京东活动前置处理流程");
                processRecord.append("京东活动前置处理流程 - ");
            }

            @Override
            public void afterProcess(String params, StringBuilder processRecord) {
                System.out.println("京东活动后置处理流程");
                processRecord.append("京东活动后置处理流程");

            }
        };
        //        return new JdPreAndPostExtension();
    }

    @Override
    public ModifyExtension1 getModifyExtension1() {
        return new ModifyExtension1() {
            @Override
            public void modify(String params, StringBuilder processRecord) {
                System.out.println("京东活动优化处理流程1");
                processRecord.append("京东活动优化处理流程1 - ");
            }
        };
        //        return new JdModifyExtension1();
    }

    @Override
    public ModifyExtension2 getModifyExtension2() {
        return new ModifyExtension2() {
            @Override
            public void modify(String params, StringBuilder processRecord) {
                System.out.println("京东活动优化处理流程2");
                processRecord.append("京东活动优化处理流程2 - ");
            }
        };
        //        return new JdModifyExtension2();
    }
}