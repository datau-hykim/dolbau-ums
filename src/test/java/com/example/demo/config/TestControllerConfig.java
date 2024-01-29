package com.example.demo.config;

import com.example.demo.service.UnitService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestControllerConfig {

    @Bean
    public UnitService unitService() {
        return new UnitService();
    }

}
