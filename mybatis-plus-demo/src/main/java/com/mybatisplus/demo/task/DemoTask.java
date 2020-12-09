package com.mybatisplus.demo.task;

import com.mybatisplus.demo.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * @author zgf
 * @description TODO
 * @time 2020/12/9 8:41
 */
@Slf4j
public class DemoTask extends QuartzJobBean {
    @Resource
    ITaskService taskService;

    /**
     * 执行定时任务
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.debug("====executeInternal====");
        taskService.sendEmail();
        log.debug("====executeInternal====");

    }
}
