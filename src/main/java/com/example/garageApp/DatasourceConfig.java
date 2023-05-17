package com.example.garageApp;

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
                        // .driverClassName(this.env.getProperty("spring.datasource.driver-class-name"))
                        // .url(this.env.getProperty("spring.datasource.url"))
                        // .username(this.env.getProperty("spring.datasource.username"))
                        // .password(this.env.getProperty("spring.datasource.password"))
                        .driverClassName("com.mysql.cj.jdbc.Driver")
                        .url("jdbc:mysql://localhost:3306/db_example")
                        .username("springuser")
                        .password("ThePassword")
                        .build();
    }
}
