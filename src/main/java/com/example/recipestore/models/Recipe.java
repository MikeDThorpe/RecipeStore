package com.example.recipestore.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    long recipe_id;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "prep_time")
    private float prep_time;
    @Column(name = "cook_time")
    private float cook_time;
    @Column(name = "path", unique = true)
    private String path;
    @Column(name = "description")
    private String description;
//    @ManyToMany(mappedBy = "recipes")
//    List<MealPlan> meal_plans;
    @Column(name = "instructions")
    private String instructions;
    @Column(name = "ingredients")
    private String ingredients;

//    @OneToMany(mappedBy = "linkedRecipe")
//    List<Instruction> instructions;
//    @OneToMany(mappedBy = "linkedRecipe")
//    List<Ingredient> ingredients;

    public Recipe(String title, String category, float prep_time, float cook_time, String description, String instructions, String ingredients) {
        this.title = title;
        this.category = category;
        this.prep_time = prep_time;
        this.cook_time = cook_time;
        // tests
        // if pass in 'fish stew' what would I expect from getPath()
        // somethingwithoutaspace
        // fish & chips, does & break?
        this.path = "/" + title.replace(' ', '-').toLowerCase();
        this.description = description;
        this.instructions = instructions;
        this.ingredients = ingredients;
    }
}
