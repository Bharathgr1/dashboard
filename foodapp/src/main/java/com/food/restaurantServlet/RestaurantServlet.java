package com.food.restaurantServlet;

import java.io.IOException;
import java.util.List;

import com.foodapp.daoimpl.RestaurantDaoImpl;
import com.foodapp.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RestaurantServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the session object
        HttpSession session = request.getSession();

        // Retrieve the username from the session
        String username = (String) session.getAttribute("username");

        // Check if the restaurant list is already stored in the session
        List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");

        // If the list is not available in the session, fetch it from the database
        if (restaurantList == null) {
            try {
                // DAO instance
                RestaurantDaoImpl restaurantDAO = new RestaurantDaoImpl();

                // Fetch all restaurant data
                restaurantList = restaurantDAO.getAllRestaurants();

                // Store the restaurant list in the session
                session.setAttribute("restaurantList", restaurantList);

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "An error occurred while fetching restaurants.");
                request.getRequestDispatcher("error.html").forward(request, response);
                return;
            }
        }

        // Set restaurants and username as request attributes
        request.setAttribute("restaurantList", restaurantList);
        request.setAttribute("username", username);

        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}
