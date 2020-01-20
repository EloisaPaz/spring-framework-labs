package com.eloisapaz.caixaeletronico.controller;

import com.eloisapaz.caixaeletronico.service.SaqueService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@SpringBootApplication
@RestController
public class SaqueController {

    private SaqueService saqueService = new SaqueService();

    @RequestMapping(value = "/saque/{valor}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity getSaque(@PathVariable("valor") int valor) {
        return new ResponseEntity(saqueService.getSaque(valor), HttpStatus.OK);
    }
}