package com.Hammasir.Mahtab;

import com.Hammasir.Mahtab.config.ConfigService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class RestaurantSpringApplication {
	private final ConfigService configService;

	public RestaurantSpringApplication(ConfigService configService) {
		this.configService = configService;
	}

	public static void main(String[] args) {
		SpringApplication.run( RestaurantSpringApplication.class, args);
	}

	@PostConstruct
	public void init() {
		configService.printApiUrl();
	}
}
