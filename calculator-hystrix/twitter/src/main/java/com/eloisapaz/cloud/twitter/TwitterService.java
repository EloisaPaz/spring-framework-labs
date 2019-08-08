package com.eloisapaz.cloud.twitter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class TwitterService {

    @RequestMapping(value = "/twitter/{user}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> twitterTotal(@PathVariable String user) {
            return new ResponseEntity<>(new TwitterCommand(user).execute().toString(), HttpStatus.OK);
    }
}