package com.Hammasir.Mahtab.config;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;

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
