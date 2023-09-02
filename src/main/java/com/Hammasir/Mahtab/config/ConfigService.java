package com.Hammasir.Mahtab.config;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ConfigService {
    @Value("${api.url}")
    private final String apiUrl;

    private final ApiProperties apiProperties;

    public ConfigService(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
        apiUrl = null;
    }

    public void printApiUrl() {
        System.out.println("API URL (using @Value): " + apiUrl);
        System.out.println("API URL (using Configuration Properties): " + apiProperties.getUrl());
    }
}

