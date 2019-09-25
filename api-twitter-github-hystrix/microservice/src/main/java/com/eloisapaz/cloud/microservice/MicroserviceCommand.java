package com.eloisapaz.cloud.microservice;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.http.ResponseEntity;
import com.google.gson.JsonObject;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

public class MicroserviceCommand extends HystrixCommand<ResponseEntity<String>> {
    private String path;
    private RestTemplate restTemplate;

    public MicroserviceCommand(String path, String key) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(key))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000)));
        this.path = path;
        this.restTemplate = new RestTemplate();
    }

    @Override
    protected ResponseEntity<String> run() throws Exception {
        return this.restTemplate.getForEntity(path, String.class);
    }

    protected ResponseEntity<String> fallBack() {
        JsonObject respostaJson = new JsonObject();
        respostaJson.addProperty("Erro", "Microservice is not available.");
        return new ResponseEntity<>(respostaJson.toString(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
