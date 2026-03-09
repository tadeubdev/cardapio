package com.example.cardapio.food.dto;

public record SuccessResponse<T>(T data, int status) {}
