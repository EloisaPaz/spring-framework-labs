package com.eloisapaz.apps.ws.exceptions;

import com.eloisapaz.apps.ws.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest request){

        String errorMessegeDescription = exception.getLocalizedMessage();
        if(errorMessegeDescription == null) errorMessegeDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessegeDescription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { NullPointerException.class, UserServiceException.class })
    public ResponseEntity<Object> handleSpecificExceptions(Exception exception, WebRequest request) {

        String errorMessageDescription = exception.getLocalizedMessage();

        if(errorMessageDescription == null) errorMessageDescription = exception.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
