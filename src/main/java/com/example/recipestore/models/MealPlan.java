package com.example.recipestore.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "meal_plans")
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_plan_id")
    private long meal_plan_id;
    @Column(name = "title")
    private String title;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "duration")
    private int duration;
    @Column(name = "exclusions")
    private String exclusions;
    @Column(name = "path", unique = true)
    private String path;
    @Column(name = "recipes")
    @ManyToMany
    @JoinTable(
            name = "meal_plan_recipes",
            joinColumns = @JoinColumn(name = "meal_plan_id"),
            inverseJoinColumns = @JoinColumn (name = "recipe_id")
    )
    private List<Recipe> recipes;

    public MealPlan(String title, LocalDate startDate, LocalDate endDate, String exclusions, List<Recipe> recipes) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.exclusions = exclusions;
        this.path = "/" + title.replace(' ', '-').toLowerCase();
        this.duration = Period.between(startDate, endDate).getDays() + 1;
        this.recipes = recipes;
    }
}
