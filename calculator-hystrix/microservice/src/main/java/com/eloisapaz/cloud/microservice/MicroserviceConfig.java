package com.eloisapaz.cloud.microservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicroserviceConfig {
    @Bean
    public Service requestService() {
        return new Service();
    }
}