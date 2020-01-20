package com.eloisapaz.caixaeletronico.config;

import com.eloisapaz.caixaeletronico.service.SaqueService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaqueConfig {

    @Bean
    public SaqueService saqueService() {
        return new SaqueService();
    }
}