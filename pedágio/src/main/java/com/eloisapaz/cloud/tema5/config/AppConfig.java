package com.eloisapaz.cloud.tema5.config;

import com.eloisapaz.cloud.tema5.modelo.*;
import com.eloisapaz.cloud.tema5.service.TollService;
import com.google.gson.Gson;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = "com.eloisapaz.cloud.tema5")
public class AppConfig{

    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer(ApplicationContext applicationContext){
        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(Service(applicationContext),JAXRSServerFactoryBean.class);
        factory.setServiceBeans(Arrays.asList(Service(applicationContext)));
        return factory.create();
    }

    @Bean
    public TollService Service(ApplicationContext applicationContext) {
        return new TollService(applicationContext);
    }

    @Bean("bike")
    public Pedagio bike(){
        return new Bike();
    }

    @Bean("caminhao")
    public Pedagio caminhao(){
        return new Caminhao();
    }

    @Bean("carro")
    public Pedagio carro(){
        return new Carro();
    }

    @Bean("moto")
    public Pedagio moto(){
        return new Moto();
    }

    @Bean("onibus")
    public Pedagio onibus(){
        return new Onibus();
    }

    @Bean
    public Gson gson(){
        return new Gson();
    }
}