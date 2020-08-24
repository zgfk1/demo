package com.example.demo.strategy.impl;



import com.example.demo.entity.Mail;
import com.example.demo.strategy.MailStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Description: 简单文本发送邮件
 *
 * @author TongWei.Chen 2018-06-15 16:46:50
 * @Project common-boot-email
 */
@Slf4j
@Component
public class SimpleMailStrategy implements MailStrategy {

    @Autowired(required=false)
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(String from, Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(from);
            message.setTo(mail.getTo());
            message.setSubject(mail.getTitle());
            message.setText(mail.getContent());
            javaMailSender.send(message);
            log.info("纯文本的邮件已经发送给【{}】。", mail.getTo());
        } catch (Exception e) {
            log.error("纯文本邮件发送时发生异常！", e);
        }
    }

    @Override
    public void sendMail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            JavaMailSenderImpl javaMailSenderImpl=(JavaMailSenderImpl)javaMailSender;
            message.setFrom(Objects.requireNonNull(javaMailSenderImpl.getUsername()));
            message.setTo(mail.getTo());
            message.setSubject(mail.getTitle());
            message.setText(mail.getContent());
            javaMailSender.send(message);
            log.info("纯文本的邮件已经发送给【{}】。", mail.getTo());
        } catch (Exception e) {
            log.error("纯文本邮件发送时发生异常！", e);
        }
    }

}
