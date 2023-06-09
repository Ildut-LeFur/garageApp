package com.example.garageApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DatasourceConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                        .driverClassName(this.env.getProperty("spring.datasource.driver-class-name"))
                        .url(this.env.getProperty("spring.datasource.url"))
                        .username(this.env.getProperty("spring.datasource.username"))
                        .password(this.env.getProperty("spring.datasource.password"))
                        .build();
    }
}
