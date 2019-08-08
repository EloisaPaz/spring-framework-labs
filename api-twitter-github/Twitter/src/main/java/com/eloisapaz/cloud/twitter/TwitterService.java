package com.eloisapaz.cloud.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterService {

    @Autowired
    private Twitter twitter;

    public TwitterData twitterTotal(String conta) throws TwitterException{
        twitter = TwitterFactory.getSingleton();
        TwitterData twitterData = new TwitterData();
        twitterData.setUser(conta);
        twitterData.setTweets(twitter.showUser(conta).getStatusesCount());
        return twitterData;
    }
}