package com.eloisapaz.cloud.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:application.properties")
public class GitHubService {
    @Value("${githubUrl}")
    private String githubUrl;

    public GithubData getNumRepositorios(String gitUser) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(githubUrl + gitUser, GithubData.class);
    }
}