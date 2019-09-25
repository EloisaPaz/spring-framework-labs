package com.eloisapaz.cloud.twitter;

import com.google.gson.JsonObject;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.beans.factory.annotation.Autowired;
import twitter4j.Twitter;

public class TwitterCommand extends HystrixCommand<JsonObject> {

    @Autowired
    private Twitter twitter;
    private String user;

    protected TwitterCommand(String user) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("twitter"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
        this.user = user;

    }

    @Override
    protected JsonObject run() throws Exception {
        JsonObject respostaTwitter = new JsonObject();
        int count = twitter.showUser(user).getStatusesCount();
        respostaTwitter.addProperty("Número de tweets: ", count);
        return respostaTwitter;
    }

    protected JsonObject fallBack() {
        JsonObject resposta = new JsonObject();
        resposta.addProperty("Erro", "Usuário não encontrado!");
        return resposta;
    }
}