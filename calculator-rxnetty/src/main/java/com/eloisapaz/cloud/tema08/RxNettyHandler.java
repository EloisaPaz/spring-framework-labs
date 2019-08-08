package com.eloisapaz.cloud.tema08;

import com.eloisapaz.cloud.tema08.calculadora.Calculadora;
import com.eloisapaz.cloud.tema08.config.CalculadoraConfig;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rx.Observable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CalculadoraConfig.class);
    private Calculadora calculadora = new Calculadora(applicationContext);
    private Map<String, String> operacoes;

    private final String healthCheckUri;
    private final HealthCheckEndpoint healthCheckEndpoint;

    public RxNettyHandler(String healthCheckUri, HealthCheckEndpoint healthCheckEndpoint) {
        this.healthCheckUri = healthCheckUri;
        this.healthCheckEndpoint = healthCheckEndpoint;
        this.operacoes = new HashMap<String, String>(){{
           put("somar","+");
            put("subtrair","-");
            put("multiplicar","*");
            put("dividir","/");
            put("potencia","^");
        }};
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
        if (request.getUri().startsWith(healthCheckUri)) {
            return healthCheckEndpoint.handle(request, response);
        } else if (request.getUri().startsWith("/calculadora/")) {

            Optional<String> operacao = getOperacao(request.getPath());
            if(!operacao.isPresent()){
                response.setStatus(HttpResponseStatus.BAD_REQUEST);
                return response.writeStringAndFlush(
                        "{\"Erro\":\"Operação inválida!\"}");
            }

            Double primeiroNum;
            Double segundoNum;
            try {
                primeiroNum = getPrimeiroValor(request.getPath());
                segundoNum = getSegundoValor(request.getPath());
                double resultado = calculadora.calcular(primeiroNum, segundoNum, operacao.get());
                return response.writeStringAndFlush(resultado + "");
            } catch (NumberFormatException e) {
                response.setStatus(HttpResponseStatus.BAD_REQUEST);
                return response.writeStringAndFlush(
                        "{\"Erro\":\"Valor inserido deve ser um número!\"}");
            } 
        } else {
            response.setStatus(HttpResponseStatus.NOT_FOUND);
            return response.close();
        }
    }

    private Optional<String> getOperacao(String path){
        String [] data = path.split("/");
        return Optional.of(operacoes.get(data[2]));
    }

    private Double getPrimeiroValor(String path){
        String [] data = path.split("/");
        return Double.parseDouble(operacoes.get(data[3]));
    }

    private Double getSegundoValor(String path){
        String [] data = path.split("/");
        return Double.parseDouble(operacoes.get(data[4]));
    }
}
