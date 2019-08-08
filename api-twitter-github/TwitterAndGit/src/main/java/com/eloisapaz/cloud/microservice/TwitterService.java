package com.eloisapaz.cloud.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:application.properties")
public class TwitterService {
    @Value("${twitterUrl}")
    private String twitterUrl;

    public TwitterData getNumTweets(String twitterUser) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(twitterUrl + twitterUser, TwitterData.class);
    }
}
