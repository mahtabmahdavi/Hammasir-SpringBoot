package com.Hammasir.Mahtab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestaurantSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run( RestaurantSpringApplication.class, args);
	}
}
