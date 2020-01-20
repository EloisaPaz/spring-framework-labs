package com.eloisapaz.caixaeletronico.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SaqueExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = SaqueException.class)
    public ResponseEntity<Object> handleSaqueException(Exception exception, WebRequest request) {

        String mensagemDeErroDescricao = exception.getLocalizedMessage();

        if(mensagemDeErroDescricao == null) mensagemDeErroDescricao = exception.toString();

        MensagemDeErro mensagemDeErro = new MensagemDeErro(mensagemDeErroDescricao);

        return new ResponseEntity<>(
                mensagemDeErro, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}