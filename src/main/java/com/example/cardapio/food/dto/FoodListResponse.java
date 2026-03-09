package com.example.cardapio.food.dto;

import com.example.cardapio.food.Food;

import java.util.List;

public record FoodListResponse(
        String message,
        List<Food> foods
) {
}
