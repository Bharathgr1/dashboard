package com.food.registerServlet;

import java.io.IOException;

import com.foodapp.daoimpl.UserDaoImpl;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegisterationServlet extends HttpServlet {
	
	
	private UserDaoImpl udai;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String userName = req.getParameter("username");
		String email = req.getParameter("email");
		String phone = req.getParameter("phoneNo");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		
		udai=new UserDaoImpl();
		int n =udai.insert((new User(name,userName,email,phone,password,address)));
		
		if(n==1) {
			resp.sendRedirect("registrationSuccessFull.jsp");
		}
		else {
			resp.sendRedirect("registrationFailure.jsp");
		}
		
	}
	
}

