package com.example.cardapio.food;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private BigDecimal price;

    public Food() {
    }

    public Food(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

}