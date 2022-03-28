package com.example.recipestore.controllers.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie removeSessionCookie = new Cookie("USESSIONID", "");
        removeSessionCookie.setMaxAge(0);
        response.addCookie(removeSessionCookie);
        response.sendRedirect("/login");
    }
}
