package com.eloisapaz.cloud.microservice;

public class TwitterData {

    private String user;
    private int numTweets;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getNumTweets() {
        return numTweets;
    }

    public void setNumTweets(int numTweets) {
        this.numTweets = numTweets;
    }
}