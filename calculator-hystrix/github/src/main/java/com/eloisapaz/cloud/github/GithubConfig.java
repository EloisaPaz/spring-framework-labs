package com.eloisapaz.cloud.github;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubConfig {

    @Bean
    public GithubService githubService() {
        return new GithubService();
    }
}