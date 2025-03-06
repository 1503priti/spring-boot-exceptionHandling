package com.priti.spring.boot.exceptionhandling.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    HttpStatus status;
    String message;

    public CustomException(HttpStatus status, String message1) {
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
