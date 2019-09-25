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

    @Value("${CONSUMER_KEY}")
    private String CONSUMER_KEY;
    @Value("${CONSUMER_KEY_SECRET}")
    private String CONSUMER_KEY_SECRET;
    @Value("${ACCESS_TOKEN}")
    private String ACCESS_TOKEN ;
    @Value("${ACCESS_TOKEN_SECRET}")
    private String ACCESS_TOKEN_SECRET;

    @Bean
    public Twitter twitterInstance(){
        ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        configBuilder.setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        TwitterFactory twitterFactory = new TwitterFactory(configBuilder.build());
        return twitterFactory.getInstance();
    }

    @Bean
    public TwitterService twitterService() {
        return new TwitterService();
    }
}
