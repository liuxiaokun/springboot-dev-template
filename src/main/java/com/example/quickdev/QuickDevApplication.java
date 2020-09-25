package com.example.quickdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author liuxiaokun
 */
@SpringBootApplication
@EnableConfigurationProperties
public class QuickDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickDevApplication.class, args);
    }
}

