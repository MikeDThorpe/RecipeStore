package com.example.recipestore.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpServletRequest.getSession(false);

        Cookie[] cookies = httpServletRequest.getCookies();
        Optional<String> authCookie = Optional.empty();
        if(cookies != null) {
            authCookie = Arrays.stream(httpServletRequest.getCookies())
                    .filter(c -> c.getName().equals("USESSIONID"))
                    .map(Cookie::getValue)
                    .findFirst();
        }

        boolean isLoginPage = httpServletRequest.getRequestURI().endsWith("login");

        // check that user is logged in
        if(isLoginPage) {
            // if user is logged in, redirect to recipe page
            if(authCookie.isPresent()) {
                httpServletResponse.sendRedirect("/recipes");
                // if user isn't logged in, continue to login page
            } else {
                chain.doFilter(request, response);
            }
        } else {
            // if the url isn't for /login
            // check if user is logged in
            if(authCookie.isPresent()){
                chain.doFilter(request, response);
            } else {
                // if the user isn't logged in, go to login page
                httpServletResponse.sendRedirect("/login");
            }
        }
    }
}
