package com.eloisapaz.cloud.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.*;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

@SpringBootApplication
@RestController
@Configuration
@PropertySource("classpath:application.properties")
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @RequestMapping(value = "/twitter/{user}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity twitterTotal(@PathVariable String user) throws TwitterException{
        return new ResponseEntity(twitterService.twitterTotal(user), HttpStatus.OK);
    }
}