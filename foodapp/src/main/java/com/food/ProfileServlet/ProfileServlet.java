package com.food.ProfileServlet;


import com.foodapp.daoimpl.UserDaoImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class ProfileServlet extends HttpServlet {

    private UserDaoImpl udai = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the username from the session
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        System.out.println("username:"+username);

        if (username != null) {
            // Fetch the full user details using the username
            User user = udai.fetchUserByUsername(username);

            if (user != null) {
                // Pass the user object to the JSP
                request.setAttribute("user", user);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "User not found.");
                request.getRequestDispatcher("loginFailure.jsp").forward(request, response);
            }
        } else {
            // Redirect to login if the session is invalid
            response.sendRedirect("login.jsp");
        }
    }
}
