package com.microservice.User_Service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public Map<String,String > handleUserNotFoundException(UserNotFoundException ex){
        Map<String,String> map = new HashMap<>();
        map.put("message",ex.getMessage());
        return map;
    }
}
