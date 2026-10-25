package com.food.loginServlet;

import java.io.IOException;

import com.foodapp.daoimpl.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private UserDaoImpl udai = new UserDaoImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate the user
        boolean valid = udai.validateUser(email, password);

        if (valid) {
            // Fetch the username from the database
            String username = udai.fetchUsernameByEmail(email);

            if (username != null) {
                // Store the username in the session
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                // Redirect to the RestaurantServlet
                response.sendRedirect("RestaurantServlet");
            } else {
                request.setAttribute("errorMessage", "User not found.");
                request.getRequestDispatcher("loginFailure.jsp").forward(request, response);
            }
        } else {
            // Handle invalid login
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("loginFailure.jsp").forward(request, response);
        }
    }
}
