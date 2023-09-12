package com.Hammasir.springboot.config;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

@Component
public class ConfigCommandLineRunner implements CommandLineRunner {
    @Value("${config.name}")
    private String configName;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Value from config file (Command Line Runner): " + configName);
    }
}
