package com.eloisapaz.cloud.twitter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

@SpringBootApplication
@RestController
@Configuration
@PropertySource("classpath:application.properties")
public class TwitterConfig {

    @Value("${consumerKey}")
    private String consumerKey;
    @Value("${consumerKeySecret}")
    private String consumerKeySecret;
    @Value("${accesToken}")
    private String accesToken;
    @Value("${accesTokenSecret}")
    private String accesTokenSecret;

    @Bean
    public Twitter twitterInstance(){
        ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        configBuilder.setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerKeySecret)
                .setOAuthAccessToken(accesToken)
                .setOAuthAccessTokenSecret(accesTokenSecret);
        TwitterFactory twitterFactory = new TwitterFactory(configBuilder.build());
        return twitterFactory.getInstance();
    }

    @Bean
    public TwitterService twitterService() {
        return new TwitterService();
    }
}
