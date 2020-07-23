package com.sdgc.demo.config;

import com.sdgc.demo.factory.YmlResourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:application.yml", encoding = "utf-8", factory = YmlResourceFactory.class)
public class DataSourceConfig {


    /**
     * a
     *
     * @return a
     */
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource businessDbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource newhomeDbDataSource() {
        return DataSourceBuilder.create().build();
    }
}
