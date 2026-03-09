package com.example.cardapio.food.exception;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException() {
        super("Food item not found.");
    }

    public FoodNotFoundException(String message) {
        super(message);
    }
}
