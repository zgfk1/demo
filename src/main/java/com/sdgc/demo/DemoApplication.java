package com.sdgc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan("com.sdgc.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
      /*  //禁用启动画面
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
        */
        SpringApplication.run(DemoApplication.class, args);

    }

}
