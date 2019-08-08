package com.eloisapaz.cloud.microservice;

public class TwitterAndGitService {

    public static TwitterAndGitData getTwitterAndGit(String twitterUser, String gitUser) {
        TwitterData twitter;
        GithubData github;
        TwitterService twitterService = new TwitterService();
        GitHubService gitHubService = new GitHubService();
        try {
            twitter = twitterService.getNumTweets(twitterUser);
        } catch (Exception e) {
            twitter = null;
        }
        try {
            github = gitHubService.getNumRepositorios(gitUser);
        } catch (Exception e) {
            github = null;
        }
        return new TwitterAndGitData(twitter, github);
    }
}