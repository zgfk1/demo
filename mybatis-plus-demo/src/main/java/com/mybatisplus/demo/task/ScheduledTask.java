package com.mybatisplus.demo.task;

import cn.hutool.core.date.DateUtil;
import com.mybatisplus.demo.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zgf
 * @description TODO
 * @time 2020/12/9 14:49
 */
@Slf4j
@Component
public class ScheduledTask {
    @Resource
    RestTemplate restTemplate;
    @Resource
    ITaskService taskService;

    /**
     * 每天凌晨0 点执行
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduledTask1() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name", "320017");
        stringObjectHashMap.put("text", "每天凌晨0 点执行" + DateUtil.now());
        stringObjectHashMap.put("title", "定时任务");

        for (String s1 : stringObjectHashMap.keySet()) {
            String s2 = stringObjectHashMap.get(s1);
            stringBuilder.append("&").append(s1).append("=").append(s2);
        }
        String s1 = stringBuilder.toString();
        s1 = s1.replaceFirst("&", "?");
        String url = "http://172.25.0.5:8080/rtx/rtx" + s1;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity.getBody());
        log.debug("====ScheduledTask====");
        System.out.println("每天凌晨0 点执行");
        log.debug("====ScheduledTask====");

    }

    /**
     * 每月第一天
     */
    @Scheduled(cron = "0 0 0 1 * ? ")
    public void scheduledTask2() {

        log.debug("====ScheduledTask====");
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name", "320017");
        stringObjectHashMap.put("text", "每月第一天" + DateUtil.now());
        stringObjectHashMap.put("title", "定时任务");

        for (String s1 : stringObjectHashMap.keySet()) {
            String s2 = stringObjectHashMap.get(s1);
            stringBuilder.append("&").append(s1).append("=").append(s2);
        }
        String s1 = stringBuilder.toString();
        s1 = s1.replaceFirst("&", "?");
        String url = "http://172.25.0.5:8080/rtx/rtx" + s1;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity.getBody());
        log.debug("====ScheduledTask====");

    }

    /**
     * 第一位 秒 分 时 日  月 星期 年
     * 每天 从零秒开始开始 每过五秒执行
     *//*
    @Scheduled(cron = "0/5 * * * * ? ")
    public void scheduledTask3() {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("name", "320017,378004");
        stringObjectHashMap.put("text", "测试定时任务每五秒发送一次" + DateUtil.now());
        stringObjectHashMap.put("title", "定时任务");

        for (String s1 : stringObjectHashMap.keySet()) {
            String s2 = stringObjectHashMap.get(s1);
            stringBuilder.append("&").append(s1).append("=").append(s2);
        }
        String s1 = stringBuilder.toString();
        s1 = s1.replaceFirst("&", "?");
        String url = "http://172.25.0.5:8080/rtx/rtx" + s1;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity.getBody());
    }*/


}
