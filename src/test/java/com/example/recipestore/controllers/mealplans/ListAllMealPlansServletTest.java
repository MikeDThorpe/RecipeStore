package com.example.recipestore.controllers.mealplans;

import com.example.recipestore.models.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListAllMealPlansServletTest {

    @Test
    void generateMealPlanFromRequest() {
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void shouldGenerateRecipesForMealPlan(int duration) {
        // setup
        ListAllMealPlansServlet listAllMealPlansServlet =  new ListAllMealPlansServlet();
        List<Recipe> recipeList = new ArrayList<>();
        for(int i = 0; i < 10; i++) recipeList.add(new Recipe());
        // execute
        List<Recipe> generatedRecipeList = listAllMealPlansServlet.generateRecipesForMealPlan(duration, recipeList);
        // verify
        assertNotNull(generatedRecipeList);
        assertEquals(duration, generatedRecipeList.size());
    }
}