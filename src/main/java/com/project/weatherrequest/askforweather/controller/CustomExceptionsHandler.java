package com.project.weatherrequest.askforweather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionsHandler {

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(WeatherNotFoundException exc) {
        CustomErrorResponse error = new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exc) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Ошибка, проверьте правильность ввода данных");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
