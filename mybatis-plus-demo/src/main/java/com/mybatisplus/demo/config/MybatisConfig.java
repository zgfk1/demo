package com.mybatisplus.demo.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 */
@Configuration
@MapperScan("com.mybatisplus.demo.dao")
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(MybatisConfiguration configuration) {
                configuration.setObjectWrapperFactory(new MapWrapperFactory());
            }
        };
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
