package com.daytona.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //Add exception handler using @ExceptionHandler
//    @ExceptionHandler
//    public ResponseEntity<Object> handleException(StudentNotFoundException e) {
//
//        //create a student error response
//        StudentErrorResponse error = new StudentErrorResponse();
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(e.getMessage());
//        error.setTimestamp(System.currentTimeMillis());
//        //return responseEntity
//       // return ResponseEntity.badRequest().body(error);
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(value = {NullPointerException.class, StudentNotFoundException.class})
    public ResponseEntity<StudentErrorResponse> handleException(Exception e){
        //create a student error response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        //return responseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
