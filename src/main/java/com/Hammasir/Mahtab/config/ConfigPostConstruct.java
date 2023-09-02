package com.Hammasir.Mahtab.config;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.PostConstruct;

@Component
public class ConfigPostConstruct {
    @Value("${config.name}")
    private String configName;

    @PostConstruct
    public void printConfig() {
        System.out.println("Value from config file (PostConstruct): " + configName);
    }
}
