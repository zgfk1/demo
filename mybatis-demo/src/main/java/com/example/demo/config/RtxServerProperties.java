package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description: TODO
 * @author: zgf
 * @time: 2020/8/21 10:10
 */
@Data
@Configuration
@PropertySource("classpath:rtx.properties")
@ConfigurationProperties(prefix = "rtx")
public class RtxServerProperties {

    private String url;

    private String title;

    private Boolean test;
}
