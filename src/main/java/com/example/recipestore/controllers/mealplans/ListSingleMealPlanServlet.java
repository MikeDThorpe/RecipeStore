package com.example.recipestore.controllers.mealplans;

import com.example.recipestore.MealPlanDAO;
import com.example.recipestore.RecipeDAO;
import com.example.recipestore.models.MealPlan;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ListSingleMealPlanServlet extends HttpServlet {
    MealPlanDAO mealPlanDAO;

    public ListSingleMealPlanServlet() {
        super();
    }

    public void init(){
        mealPlanDAO = new MealPlanDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MealPlan mealPlanToDisplay = fetchMealPlanForDisplay(request);
        if(mealPlanToDisplay != null) {
            request.setAttribute("mealplan", mealPlanToDisplay);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/mealplan.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/meal-plans");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public MealPlan fetchMealPlanForDisplay(HttpServletRequest request){
        String mealPlanIdFromPath = String.valueOf(request.getPathInfo()).replace("/", "");
        long mealPlaneId = Long.parseLong(mealPlanIdFromPath);
        return mealPlanDAO.getMealPlan(mealPlaneId);
    }
}
