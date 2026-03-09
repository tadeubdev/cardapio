package com.example.cardapio.food.infra;

import com.example.cardapio.food.dto.ErrorResponse;
import com.example.cardapio.food.exception.FoodNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FoodNotFoundException.class)
    private ResponseEntity<ErrorResponse> foodNotFoundHandler(FoodNotFoundException ex) {
        return buildResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ErrorResponse> genericHandler(Exception ex) {
        return buildResponse("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> buildResponse(String message, HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(new ErrorResponse(message, status.value()));
    }
}
