package com.Hammasir.springboot.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class ApiConfig {
    @Value("${api.url}")
    private final String apiUrl;

    private final ApiProperties apiProperties;

    public ApiConfig(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
        apiUrl = null;
    }

    @PostConstruct
    public void printApiUrl() {
        System.out.println("API URL (using @Value): " + apiUrl);
        System.out.println("API URL (using @ConfigurationProperties): " + apiProperties.getUrl());
    }
}
