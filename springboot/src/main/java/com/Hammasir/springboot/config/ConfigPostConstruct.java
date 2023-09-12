package com.Hammasir.springboot.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class ConfigPostConstruct {
    @Value("${config.name}")
    private String configName;

    @PostConstruct
    public void printConfig() {
        System.out.println("Value from config file (PostConstruct): " + configName);
    }
}
