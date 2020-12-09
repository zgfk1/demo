package com.mybatisplus.demo.config;

import com.mybatisplus.demo.task.DemoTask;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zgf
 * @description TODO
 * @time 2020/12/9 8:43
 */
@Slf4j
@Configuration
public class QuartzConfig {

    /*@Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(DemoTask.class).withIdentity("demoTask").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                //设置时间周期单位秒
                .withIntervalInSeconds(10)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("demoTask")
                .withSchedule(scheduleBuilder)
                .build();
    }*/
}
