package com.example.recipestore.controllers.recipes;

import com.example.recipestore.RecipeDAO;
import com.example.recipestore.models.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ListSingleRecipeServlet extends HttpServlet {
    RecipeDAO recipeDAO;

    public ListSingleRecipeServlet(){super();}

    public void init() {
        recipeDAO = new RecipeDAO();
    }

    // GET Request -> /recipes/:id = show a single recipe
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Recipe recipe = fetchRecipeForDisplay(request);
        RequestDispatcher dispatcher;
        if(recipe != null) {
            request.setAttribute("recipe", recipe);
            dispatcher = request.getRequestDispatcher("/recipe.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/recipes");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public Recipe fetchRecipeForDisplay(HttpServletRequest request){
        String recipeIdFromPath = String.valueOf(request.getPathInfo()).replace("/", "");
        long recipeId = Long.parseLong(recipeIdFromPath);
        return recipeDAO.getRecipe(recipeId);
    }
}
