package com.talendig.springboottalendig.errorhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice  //Indica que es un componente para la gestion de excepciones
public class SimpleExceptionHandler extends ResponseEntityExceptionHandler {

    //Definimos unos métodos para gestionar excepciones que puedan ocurrir.

    @ExceptionHandler(SQLException.class)
    public ResponseEntity handleSQLException(SQLException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now().toString());
        body.put("mensaje", "Excepcion SQL -> Aqui podriamos definir una respuesta o mensaje especifico");
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity handleNumberFormatException(NumberFormatException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Error al formatear número", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);

    }

}
