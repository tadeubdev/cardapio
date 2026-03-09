package com.example.cardapio.food;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food create(Food food) {
        return foodRepository.save(food);
    }

    public Food findById(UUID id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    public Food update(UUID id, Food food) {
        Food existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found"));

        // Atualiza apenas os campos que foram enviados (não nulos)
        if (food.getName() != null) {
            existingFood.setName(food.getName());
        }
        if (food.getPrice() != null) {
            existingFood.setPrice(food.getPrice());
        }

        return foodRepository.save(existingFood);
    }

    public void delete(UUID id) {
        foodRepository.deleteById(id);
    }

    public java.util.List<Food> findAll() {
        return foodRepository.findAll();
    }
}
