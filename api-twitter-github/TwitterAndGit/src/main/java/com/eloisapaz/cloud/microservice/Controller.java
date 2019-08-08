package com.eloisapaz.cloud.microservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

@RestController
public class Controller {

    @RequestMapping(value = "/github/{gitUser}/twitter/{ttUser}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> getUser(@PathVariable("gitUser") String gitUser, @PathVariable("ttUser") String ttUser){
        return new ResponseEntity(TwitterAndGitService.getTwitterAndGit(ttUser, gitUser), HttpStatus.OK);
    }
}