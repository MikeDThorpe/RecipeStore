package com.example.recipestore.models;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "instructions")
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instruction_id")
    private Long instruction_id;
    @Column(name = "step")
    private int step;
    @Column(name = "content")
    private String content;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe linkedRecipe;
}
