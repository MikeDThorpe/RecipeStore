package com.example.recipestore.controllers.auth;

import com.example.recipestore.DAO.UserDAO;
import com.example.recipestore.models.user.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

public class LoginServlet extends HttpServlet {
    UserDAO userDAO;

    public LoginServlet() {
        super();
    }

    public void init(){
        userDAO = new UserDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if(action.equals("login")) {
            handleLogin(request, response, user);
        } else if (action.equals("signup")) {
            handleSignUp(request, response, user);
        }
    }
    public void handleLogin(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
        boolean isUser = userDAO.authenticateUser(user);
        if(!isUser){
            response.sendRedirect("/login.jsp");
        } else {
            HttpSession httpSession = request.getSession(true); // start a new http session
            httpSession.setAttribute("isActive", true); // create a session object
            httpSession.setAttribute("username", user.getUsername()); // add username to session object
            // create session cookie
            Cookie authCookie = new Cookie("USESSIONID", String.valueOf(UUID.randomUUID()));
            response.addCookie(authCookie);

            // security - JWTs?
            // does the value of the cookie match a set value - only checking the cookie is there and not checking its value
            // store username to check against??
            // sql injection

            // http://mysite.com?lookuoid=123
            // http://mysite.com?lookuoid=123`;drop table product;
            // var product = runsql('select * from product where id = 123;drop table product;');

            // shape of data - what shape should data be? eg id == interger
            // var id = myService.clean(inputId); - looks for and removes malicious input or rejects input
            // String statement = "select * from product where id = {chars(3)};
            //  connection.execute(statement, id)
            // "prepared statements"

            // redirect to hub page now logged in
            response.sendRedirect("/recipes");
        }
    }

    public void handleSignUp(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        boolean userCreated = userDAO.registerNewUser(user);
        if(!userCreated) {
            request.setAttribute("errorMessage", "Error creating user. Please try again.");
        } else {
            request.setAttribute("successMessage", "User created!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }
}
