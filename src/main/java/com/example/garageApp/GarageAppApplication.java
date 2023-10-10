package com.example.garageApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(scanBasePackages= {"com.example.garageApp"},exclude={DataSourceAutoConfiguration.class})
@EntityScan("com.example.garageApp")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class GarageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageAppApplication.class, args);
	}

}
