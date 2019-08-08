package com.eloisapaz.cloud.microservice;

public class TwitterAndGitData {

    private GithubData github;
    private TwitterData twitter;

    public TwitterAndGitData(TwitterData twitter, GithubData github) {
        this.github = github;
        this.twitter = twitter;
    }

    public GithubData getGithub() {
        return github;
    }

    public void setGithub(GithubData github) {
        this.github = github;
    }

    public TwitterData getTwitter() {
        return twitter;
    }

    public void setTwitter(TwitterData twitter) {
        this.twitter = twitter;
    }
}