package com.eloisapaz.cloud.github;

import org.springframework.web.bind.annotation.PathVariable;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import java.io.IOException;

public class GithubService {
    public GithubData getRepositorios(@PathVariable("user") String user) throws IOException {
        GitHub github = new GitHubBuilder().build();
        GithubData githubData = new GithubData();
        githubData.setUser(user);
        githubData.setRepositorios(github.getUser(user).getRepositories().size());
        return githubData;
    }
}