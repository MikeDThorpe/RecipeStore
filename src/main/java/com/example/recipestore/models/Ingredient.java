package com.example.recipestore.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private long ingredient_id;
    @Column(name = "title")
    private String title;
    @Column(name = "quantity")
    private float quantity;
    @Column(name = "measurement")
    private String measurement;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe linkedRecipe;
}
