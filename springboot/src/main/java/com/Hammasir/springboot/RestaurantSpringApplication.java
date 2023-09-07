package com.Hammasir.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableScheduling
@EntityScan
public class RestaurantSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run( RestaurantSpringApplication.class, args);
	}
}
