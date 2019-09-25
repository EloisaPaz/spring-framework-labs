package com.eloisapaz.cloud.microservice;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
public class Service {

    @Value("${twitterUrl}")
    private String twitterUrl;
    @Value("${githubUrl}")
    private String githubUrl;

    @RequestMapping(value = "/github/{gitUser}/twitter/{ttUser}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> getUser(@PathVariable("gitUser") String gitUser, @PathVariable("ttUser") String ttUser,  String microservice){
        ResponseEntity<String> respostaGithub = new MicroserviceCommand(githubUrl+gitUser,microservice).execute();
        ResponseEntity<String> respostaTwitter = new MicroserviceCommand(twitterUrl+ttUser,microservice).execute();

        JsonParser jsonParser = new JsonParser();
        JsonElement github = jsonParser.parse(respostaGithub.getBody());
        JsonElement twitter = jsonParser.parse(respostaTwitter.getBody());

        JsonObject respostaJson = new JsonObject();
        respostaJson.add("github", github);
        respostaJson.add("twitter", twitter);
        return new ResponseEntity<>(respostaJson.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/github/{user}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> getRepositoriesCount(@PathVariable("user") String user, String microservice) {
        return new MicroserviceCommand(githubUrl+user, microservice).execute();
    }

    @RequestMapping(value = "/twitter/{user}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<String> getTweetsCount(@PathVariable("user") String user, String microservice) {
        return new MicroserviceCommand(twitterUrl+user, microservice).execute();
    }
}