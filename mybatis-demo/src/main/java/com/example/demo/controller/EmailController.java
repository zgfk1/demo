package com.example.demo.controller;

import cn.hutool.json.JSONObject;
import com.example.demo.biz.MailBiz;
import com.example.demo.enums.MailContentTypeEnum;
import com.example.demo.service.MailService;
import com.example.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: zgf
 * @time: 2020/8/22 16:01
 */
@Slf4j
@RestController
public class EmailController {
    /**
     * 服务对象
     */
   /* @Resource
    private MailService mailService;

    @PostMapping("sedRtx")
    public void sedRtx(@RequestBody JSONObject data) {
        //String toAddr, String title, String content
        mailService.sendTextMail(data.get("toAddr").toString(),data.get("title").toString(),data.get("content").toString());
    }*/

    @Resource
    private JavaMailSender javaMailSender;

    @PostMapping("sedEmail")
    public void sedRtx(@RequestBody JSONObject data) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("1421504642@qq.com");
        msg.setTo("1421504642@qq.com");
        msg.setSubject("程序新视界");
        msg.setText("技术分享");
        javaMailSender.send(msg);
    }
    @Resource
    MailBiz mailBiz;

    @PostMapping("sedEmailMailBiz")
    public void sedEmailMailBiz(@RequestBody JSONObject data) {

        mailBiz.contentType(MailContentTypeEnum.TEXT).content("技术分享11").title("程序新视界11111").to("1421504642@qq.com").send();
    }


}
