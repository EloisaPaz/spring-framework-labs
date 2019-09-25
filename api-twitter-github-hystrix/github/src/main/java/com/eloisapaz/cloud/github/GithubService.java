package com.eloisapaz.cloud.github;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class GithubService {

    @RequestMapping(value = "/github/{user}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getRepositorios(@PathVariable("user") String user) {
        return  new ResponseEntity<>(new GithubCommand(user).execute().toString(), HttpStatus.OK);
    }
}
