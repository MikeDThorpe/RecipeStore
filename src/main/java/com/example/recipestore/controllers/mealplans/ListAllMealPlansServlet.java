package com.example.recipestore.controllers.mealplans;

import com.example.recipestore.MealPlanDAO;
import com.example.recipestore.RecipeDAO;
import com.example.recipestore.models.MealPlan;
import com.example.recipestore.models.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListAllMealPlansServlet extends HttpServlet {
    MealPlanDAO mealPlanDAO;
    RecipeDAO recipeDAO;

    public ListAllMealPlansServlet() {
        super();
    }

    public void init(){
        mealPlanDAO = new MealPlanDAO();
        recipeDAO = new RecipeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MealPlan> allMealPlans = mealPlanDAO.getAllMealPlans();
        if (allMealPlans == null) {
            request.setAttribute("errorMessage", "Error loading your meal plans. Please try again later.");
        } else if (allMealPlans.size() == 0) {
            request.setAttribute("warningMessage", "You have no meals plans. Add one below.");
        } else {
            request.setAttribute("mealplans", allMealPlans);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mealplans.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MealPlan generatedMealPlan = generateMealPlanFromRequest(request);
        if(generatedMealPlan == null){
            request.setAttribute("errorMessage", "Error creating meal plan. You need to add more recipes.");
        } else {
            mealPlanDAO.saveMealPlan(generatedMealPlan);
            request.setAttribute("successMessage", "Meal plan saved");
        }
        doGet(request, response);
    }


    public MealPlan generateMealPlanFromRequest(HttpServletRequest request){
        String title = request.getParameter("title");
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        String exclusions = request.getParameter("exclusions");
        LocalDate parsedStartDate = LocalDate.parse(startDate);
        LocalDate parsedEndDate = LocalDate.parse(endDate);

        List<Recipe> recipesForMealPlan = new ArrayList<>();
        MealPlan generatedMealPlan = new MealPlan(title, parsedStartDate, parsedEndDate, exclusions, recipesForMealPlan);

        List<Recipe> recipesFiltered = recipeDAO.getAllRecipes()
                .stream()
                .filter(recipe -> !recipe.getCategory().equals(exclusions))
                .collect(Collectors.toList());
        if(recipesFiltered.size() < generatedMealPlan.getDuration()){
            // not enough recipes in the database to create meal plan
            return null;
        }
        // create meal plan from recipesFiltered list
        recipesForMealPlan = generateRecipesForMealPlan(generatedMealPlan.getDuration(), recipesFiltered);
        generatedMealPlan.setRecipes(recipesForMealPlan);
        return generatedMealPlan;
    }

    public List<Recipe> generateRecipesForMealPlan(int duration, List<Recipe> recipeList){
        List<Recipe> generatedRecipeList = new ArrayList<>();
        for(int i = 0; i < duration; i++){
            if(recipeList.size() == 1){
                generatedRecipeList.add(recipeList.get(0));
                break;
            } else {
                Random rand = new Random();
                int randNumber = rand.nextInt(recipeList.size()); // 0 - recipeList.size() - 1
                generatedRecipeList.add(recipeList.get(randNumber)); // add recipe to list from random index
                recipeList.remove(randNumber);
            }
        }
        return generatedRecipeList;
    }
}
