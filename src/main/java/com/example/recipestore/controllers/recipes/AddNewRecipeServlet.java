package com.example.recipestore.controllers.recipes;

import com.example.recipestore.DAO.RecipeDAO;
import com.example.recipestore.models.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class AddNewRecipeServlet extends HttpServlet {
    RecipeDAO recipeDAO;

    public void init() {
        recipeDAO = new RecipeDAO();
    }

    // GET Request -> /recipes/new = show add recipe form page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/form.jsp");
        dispatcher.forward(request, response);
    }
    // POST Request -> /recipes/new = create a new recipe from the form inputs
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Recipe recipeSaved = generateRecipeFromRequest(request);
        if(recipeSaved == null){
            request.setAttribute("errorMessage",
                    "An error occurred. Your recipe has not been saved. Please try again later.");
        } else {
            request.setAttribute("successMessage",
                    "Recipe saved.");
        }
        doGet(request, response);
    }

    public Recipe generateRecipeFromRequest(HttpServletRequest request){
        String title = request.getParameter("title");
        String category = request.getParameter("category");
        String prep_time = request.getParameter("prep_time");
        String cook_time = request.getParameter("cook_time");
        String description = request.getParameter("description");
        String instructions = request.getParameter("instructions");
        String ingredients = request.getParameter("ingredients");

        float prep_time_float = Float.parseFloat(prep_time);
        float cook_time_float = Float.parseFloat(cook_time);
        Recipe newRecipe = new Recipe(title, category, prep_time_float, cook_time_float, description, instructions, ingredients);
        try {
            recipeDAO.saveRecipe(newRecipe);
            return newRecipe;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
