package com.eloisapaz.cloud.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import java.io.IOException;

@SpringBootApplication
@RestController
public class GithubController {

    @Autowired
    private GithubService githubService;

    @RequestMapping(value = "/github/{user}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity getRepository(@PathVariable("user") String user) throws IOException {
        return new ResponseEntity(githubService.getRepositorios(user), HttpStatus.OK);
    }
}