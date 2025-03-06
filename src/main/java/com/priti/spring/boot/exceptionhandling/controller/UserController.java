package com.priti.spring.boot.exceptionhandling.controller;
import com.priti.spring.boot.exceptionhandling.exception.CustomException;
import com.priti.spring.boot.exceptionhandling.exception.ErrorResponse;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping(value = "/api/")
public class UserController {

    @GetMapping(path = "/get-user")
    public ResponseEntity<?> getUser() {
        // your business logic
        //throw new NullPointerException("throwing null pointer exception for testing");

        try {
            throw new CustomException(HttpStatus.BAD_REQUEST, "UserID is missing");
        }
        catch (CustomException e) {
            ErrorResponse errorResponse = new ErrorResponse(new Date(), e.getMessage(), e.getStatus().value());
             return new ResponseEntity<>(errorResponse,e.getStatus());
            }


        catch(Exception e)
            {
                ErrorResponse errorResponse = new ErrorResponse(new Date(), e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }





