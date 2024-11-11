package com.kjgs.异常;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Object handleException(Exception ex){
        ex.printStackTrace();
        return ex.getMessage();
    }
}
