package com.example.recipestore.controllers.mealplans;

import com.example.recipestore.models.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ListAllMealPlansServletTest {

    @Test
    void generateMealPlanFromRequest() {
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
//    @Docs("Testing happy path generation of mean plan")
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

    // given x days and y recipes we get a mean plan with different recipe each day

//     given x days and 1 recipe that 1 recipe should be used for all days
//    @Test()
//    @Expects(InvalidParameterException)
//    public shouldThrowWhenBadParamValuesProvided() {
//
//    }
//
//    @Test()
//    public shouldReturnEmptyCollectionBadParamValuesProvided() {
//
//    }

    // test for bug described in JIRA-1234
    // data y throws exception instead of empty collection
}