package com.example.recipestore.controllers.recipes;

import com.example.recipestore.RecipeDAO;
import com.example.recipestore.models.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListAllRecipesServlet extends HttpServlet {
    RecipeDAO recipeDAO;

    public void init(){
        recipeDAO =  new RecipeDAO();
    }

    // GET Request -> /recipes = list all recipes in a table
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get recipes from database
        List<Recipe> allRecipes = recipeDAO.getAllRecipes();
        System.out.println(allRecipes);
        if (allRecipes == null){
            request.setAttribute("errorMessage", "An error occurred finding your recipes. Try again later.");
        } else if (allRecipes.size() == 0){
            request.setAttribute("warningMessage", "You have no recipes to show. Why not add one now?");
        } else {
            request.setAttribute("recipes", allRecipes);
        }
        // create response
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipes.jsp");
        dispatcher.forward(request, response);
    }
}
