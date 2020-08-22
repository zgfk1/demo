package com.example.demo.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.config.RtxServerProperties;
import com.example.demo.entity.RtxNotification;
import com.example.demo.service.UserInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @description: TODO
 * @author: zgf
 * @time: 2020/8/21 10:25
 */
@Slf4j
@RestController
public class RtxController {

    @Resource
    RestTemplate restTemplate;
    @Resource
    RtxServerProperties rtxServerProperties;

    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    @PostMapping("existRtxNotification")
    public String existRtxNotification(@RequestBody JSONObject data) {
        ObjectMapper mapper = new ObjectMapper();
        RtxNotification rtxNotification = new RtxNotification();
        try {
            rtxNotification = mapper.readValue(JSONUtil.toJsonStr(data), RtxNotification.class);
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            Map<String, Object> map = this.userInfoService.existRtxNotification(rtxNotification);
            //{
            //    "count": 0
            //}
            log.debug("map{}",JSONUtil.toJsonPrettyStr(map));
            if (CollectionUtil.isNotEmpty(map) && Integer.parseInt(Objects.toString(map.get("count"), "0")) == 0) {
                log.debug("return new ResponseDTO(ResultCode.SUCCESS_CODE, \"0\");");
                return "return new ResponseDTO(ResultCode.SUCCESS_CODE, \"0\");";
            } else {
                log.debug("return new ResponseDTO(ResultCode.SUCCESS_CODE, \"1\");");

                return "return new ResponseDTO(ResultCode.SUCCESS_CODE, \"1\");";

            }
        } catch (Exception e) {
            log.debug("查询失败", e);

        }
        return "xxxxxxxxxxxxxxxx";
    }

    @PostMapping("sedRtx")
    public void sedRtx(@RequestBody JSONObject data) {
        StringBuilder stringBuilder = new StringBuilder();
        String rtxUrl = rtxServerProperties.getUrl();
        String title = rtxServerProperties.getTitle();

        data.put("title", title);
        for (String s1 : data.keySet()) {
            String s2 = Objects.toString(data.get(s1), "");
            stringBuilder.append("&").append(s1).append("=").append(s2);
        }
        String s1 = stringBuilder.toString();
        s1 = s1.replaceFirst("&", "?");
        rtxUrl = rtxUrl + s1;

        log.info("RTXNotificationServiceImpl_sendRtxNotification_rtxUrl{}", rtxUrl);

        ResponseEntity<String> forEntity = restTemplate.getForEntity(rtxUrl, String.class);
        HttpStatus statusCode = forEntity.getStatusCode();
        String body = forEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> tmpMap = new HashMap<>();
        try {
            tmpMap = mapper.readValue(body, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tmpMap.put("HttpStatus", statusCode);

        data.put("success", "0");
        if (CollectionUtil.isNotEmpty(tmpMap) && 200 == statusCode.value()) {
            data.put("success", "1");
            data.put("returnMessage", JSONUtil.toJsonStr(tmpMap));
        }
        String name = Objects.toString(data.get("name"), "");
        String delimiter = ",";
        ArrayList<Map> jsonObjects = new ArrayList<>();
        if (name.contains(delimiter)) {
            String[] split = name.split(delimiter);
            for (String s : split) {
                Map<String, Object> jsonObject = new JSONObject();
                jsonObject.putAll(data);
                jsonObject.put("name", s);
                jsonObjects.add(jsonObject);
            }
            String s2 = JSONUtil.toJsonStr(jsonObjects);
            JSONArray array = JSONUtil.parseArray(s2);
            List<RtxNotification> rtxNotificationList = JSONUtil.toList(array, RtxNotification.class);
            log.debug("RTXNotificationServiceImpl_sendRtxNotification_rtxNotificationList{}",
                    JSONUtil.toJsonPrettyStr(rtxNotificationList));

            //this.insertList(rtxNotificationList);
        } else {
            RtxNotification rtxNotification = new RtxNotification();
            try {
                rtxNotification = mapper.readValue(JSONUtil.toJsonStr(data), RtxNotification.class);
                log.debug("RTXNotificationServiceImpl_sendRtxNotification_rtxNotification{}",
                        JSONUtil.toJsonPrettyStr(rtxNotification));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //this.insert(rtxNotification);
        }


        log.debug("RTXNotificationServiceImpl_sendRtxNotification_body{}", JSONUtil.toJsonPrettyStr(body));
       /* StringBuilder stringBuilder = new StringBuilder();
        String rtxUrl = rtxServerProperties.getUrl();

        for (String s1 : data.keySet()) {
            String s2 = Objects.toString(data.get(s1), "");
            stringBuilder.append("&").append(s1).append("=").append(s2);
        }
        String s1 = stringBuilder.toString();
        s1 = s1.replaceFirst("&", "?");
        rtxUrl = rtxUrl + s1;

        log.info(rtxUrl);

        ResponseEntity<String> forEntity = restTemplate.getForEntity(rtxUrl, String.class);
        HttpStatus statusCode = forEntity.getStatusCode();
        String body = forEntity.getBody();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> tmpMap = new HashMap<>();
        try {
            tmpMap = mapper.readValue(body, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (CollectionUtil.isNotEmpty(tmpMap)&&200 == statusCode.value()) {

        }


        log.debug("RTXNotificationServiceImpl_sendRtxNotification_body{}", JSONUtil.toJsonPrettyStr(body));*/
    }
}
