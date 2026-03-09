package com.example.cardapio.food;

import com.example.cardapio.food.dto.*;
import com.example.cardapio.food.exception.FoodNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<FoodListResponse>> findAll() {
        List<Food> foods = foodService.findAll();
        var data = new FoodListResponse("Alimentos encontrados com sucesso", foods);
        return ResponseEntity.ok(new SuccessResponse<>(data, 200));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<CreateFoodResponse>>create(@RequestBody Food food) {
        Food createdFood = foodService.create(food);
        var data = new CreateFoodResponse("Alimento criado com sucesso", createdFood);
        return ResponseEntity.ok(new SuccessResponse<>(data, 201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<FindFoodByIdResponse>> findById(@PathVariable UUID id) {
        Food food = foodService.findById(id);
        if (food == null) {
            throw new FoodNotFoundException();
        }
        var data = new FindFoodByIdResponse(food);
        return ResponseEntity.ok(new SuccessResponse<>(data, 200));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable UUID id, @RequestBody Food food) {
        foodService.update(id, food);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        foodService.delete(id);
    }
}
