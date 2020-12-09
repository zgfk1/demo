package com.mybatisplus.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.mybatisplus.demo.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zgf
 * @description TODO
 * @time 2020/12/9 14:50
 */
@Slf4j
@Service("taskService")
public class TaskServiceImpl implements ITaskService {
    @Override
    public void sendEmail() {
        System.out.println("已发送邮件。"+ DateUtil.now());
    }
}
