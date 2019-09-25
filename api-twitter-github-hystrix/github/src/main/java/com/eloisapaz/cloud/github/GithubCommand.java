package com.eloisapaz.cloud.github;

import com.google.gson.JsonObject;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import org.eclipse.egit.github.core.service.RepositoryService;

public class GithubCommand extends HystrixCommand<JsonObject> {

    private final String user;
    private RepositoryService repositoryService;

    protected GithubCommand(String user) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("githubMicroservice"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(10000)));
        this.user = user;
        repositoryService = new RepositoryService();
    }

    @Override
    protected JsonObject run() throws Exception {
        JsonObject respostaGithub = new JsonObject();
        int cont = repositoryService.getRepositories(user).size();
        respostaGithub.addProperty("Número de repositórios: ", cont);
        return respostaGithub;
    }

    protected JsonObject fallBack() {
        JsonObject resposta = new JsonObject();
        resposta.addProperty("Erro", "Usuário não encontrado!");
        return resposta;
    }
}