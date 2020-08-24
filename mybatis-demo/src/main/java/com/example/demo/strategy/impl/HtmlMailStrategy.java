package com.example.demo.strategy.impl;



import com.example.demo.entity.Mail;
import com.example.demo.strategy.MailStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Description: HTML格式发送邮件
 *
 * @author TongWei.Chen 2018-06-15 16:49:18
 * @Project common-boot-email
 */
@Slf4j
@Component
public class HtmlMailStrategy implements MailStrategy {

    @Autowired(required=false)
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(String from, Mail mail) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getTitle());
            helper.setText(mail.getContent(), true);
            javaMailSender.send(message);
            log.info("html邮件已经发送{}。", mail.getTo());
        } catch (MessagingException e) {
            log.error("发送html邮件时发生异常！", e);
        }
    }
}
