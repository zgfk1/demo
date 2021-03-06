package com.example.demo.biz;


import com.example.demo.entity.Mail;
import com.example.demo.enums.MailContentTypeEnum;
import com.example.demo.factory.MailFactory;
import com.example.demo.strategy.MailStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author TongWei.Chen 2018-06-15 17:02:00
 * @Description: 邮件发送类
 * @Project common-boot-email
 **/
@Component
public class MailBiz {
    @Autowired
    private Map<String, MailStrategy> mailStrategy;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 邮件实体
     */
    private final Mail mail = new Mail();

    /**
     * 设置邮件标题
     *
     * @param title：邮件标题
     * @return
     */
    public MailBiz title(String title) {
        mail.setTitle(title);
        return this;
    }

    /**
     * 设置邮件内容
     *
     * @param content：内容
     * @return
     */
    public MailBiz content(String content) {
        mail.setContent(content);
        return this;
    }

    /**
     * 设置邮件格式
     *
     * @param typeEnum：邮件格式
     * @return
     */
    public MailBiz contentType(MailContentTypeEnum typeEnum) {
        mail.setContentType(typeEnum.value());
        return this;
    }

    /**
     * 设置请求目标邮件地址
     *
     * @param to：请求目标邮件地址
     * @return
     */
    public MailBiz to(String to) {
        mail.setTo(to);
        return this;
    }

    /**
     * 设置模板名称
     *
     * @param templateName
     * @return
     */
    public MailBiz templateName(String templateName) {
        mail.setTemplateName(templateName);
        return this;
    }

    /**
     * 模板发送的变量
     *
     * @param maps：maps
     * @return
     */
    public MailBiz maps(Map<String, Object> maps) {
        mail.setMaps(maps);
        return this;
    }

    /**
     * 执行发送邮件
     */
    public void send() {
        String key = MailFactory.getInstance().get(mail.getContentType());
        this.mailStrategy.get(key).sendMail(from, mail);
    }
}
