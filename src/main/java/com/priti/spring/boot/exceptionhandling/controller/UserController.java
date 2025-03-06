package com.priti.spring.boot.exceptionhandling.controller;
import com.priti.spring.boot.exceptionhandling.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class UserController {

    @GetMapping(path = "/get-user")
    public String getUser(){
        // your business logic
        //throw new NullPointerException("throwing null pointer exception for testing");
        throw new CustomException(HttpStatus.BAD_REQUEST,"request is not correct, UserID is missing");
    }

}
