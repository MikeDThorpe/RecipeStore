package com.example.recipestore.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeClassTest {

    @Test
    void shouldCreatePathFromTitle(){
        // setup
        String recipeTitle = "recipe title to test";
        //execute
        Recipe recipe = new Recipe(
                recipeTitle,
                "meat",
                15,
                15,
                "description",
                "instructions",
                "ingredients");
        // verify
        assertNotNull(recipe);
        assertEquals(recipe.getPath(), "/recipe-title-to-test");
    }

    @Test
    void shouldRemoveAmpersandFromPath(){
        String recipeTitle = "Fish & chips";
        Recipe recipe = new Recipe(
                recipeTitle,
                "meat",
                15,
                15,
                "description",
                "instructions",
                "ingredients");
        assertNotNull(recipe);
        assertEquals(recipe.getPath(), "/fish-and-chips");
    }
}