package com.eloisapaz.cloud.tema5.service;

import com.eloisapaz.cloud.tema5.modelo.*;
import com.google.gson.Gson;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Service
@ApplicationPath("/pedagio")
public class TollService extends Application {

    @Autowired
    private Gson gson;
    private ApplicationContext applicationContext;

    public TollService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response tabelaValores(){
        Map<String, Double> valoresPedagio = new HashMap<String, Double>();
        valoresPedagio.put("Bike: R$", Bike.PRECO);
        valoresPedagio.put("Caminhão (Valor base. É adicionado R$0.50 de taxa por eixo.): R$", Caminhao.PRECO);
        valoresPedagio.put("Carro: R$", Carro.PRECO);
        valoresPedagio.put("Moto: R$", Moto.PRECO);
        valoresPedagio.put("Ônibus: R$", Onibus.PRECO);

        Response response = Response.status(200).entity(gson.toJson(valoresPedagio)).build();
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{tipoVeiculo}/{pagamento}")
    public Response getPagamento(@PathParam("tipoVeiculo")String tipoVeiculo, @PathParam("pagamento")double pagamento){
        Response response;
        try{
            Pedagio pedagio = (Pedagio) applicationContext.getBean(tipoVeiculo);
            if(pagamento < pedagio.getPreco()){
                response = Response.status(400).entity(gson.toJson("Valor insuficiente!")).build();
            }else{
                response = Response.status(Response.Status.OK).entity(gson.toJson("{Troco R$: " + pedagio.valorPago(pagamento)+ "}")).build();
            }
        }catch (BeansException e){
            response = Response.status(400).entity(gson.toJson("Veículo não cadastrado!")).build();
        }
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{tipoVeiculo}/{eixos}/{pagamento}")
    public Response getPagamentoCaminhao(@PathParam("tipoVeiculo")String tipoVeiculo, @PathParam("eixos")int eixos, @PathParam("pagamento")double pagamento){
        Response response;
        try{
            Caminhao caminhao = (Caminhao) applicationContext.getBean(tipoVeiculo);
            caminhao.setNumEixos(eixos);
            if (pagamento < caminhao.getPreco()){
                response = Response.status(400).entity(gson.toJson("Valor insuficiente!")).build();
            }else{
                response = Response.status(Response.Status.OK).entity(gson.toJson("{Troco R$: " + caminhao.valorPago(pagamento)+ "}")).build();
            }
        }catch (BeansException e){
            response = Response.status(400).entity(gson.toJson("Veículo não cadastrado!")).build();
        }
        return response;
    }
}