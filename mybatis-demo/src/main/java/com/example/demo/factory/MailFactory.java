package com.example.demo.factory;


import com.example.demo.enums.MailContentTypeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 邮件发送bean工厂类
 *
 * @author TongWei.Chen 2018-06-15 16:39:07
 * @Project common-boot-email
 */
public class MailFactory {

    private MailFactory() {}

    private static final class InnerMailFactory {
        private static final MailFactory MAIL_FACTORY = new MailFactory();
    }

    private static Map<String, String> maps = new HashMap<>();

    static {
        maps.put(MailContentTypeEnum.TEXT.value(), getStrategyClassName("simple"));
        maps.put(MailContentTypeEnum.HTML.value(), getStrategyClassName("html"));
        maps.put(MailContentTypeEnum.TEMPLATE.value(), getStrategyClassName("template"));
    }

    public static  MailFactory getInstance() {
        return InnerMailFactory.MAIL_FACTORY;
    }

    public String get(String type) {
        return maps.get(type);
    }

    /**
     * 获取策略类名
     *
     * @param classNamePrefix：类名前缀
     * @return
     */
    private static String getStrategyClassName(String classNamePrefix) {
        return classNamePrefix + "MailStrategy";
    }

}
