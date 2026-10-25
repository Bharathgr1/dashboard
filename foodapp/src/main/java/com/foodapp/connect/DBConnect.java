package com.foodapp.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
private static Connection con;
	
	public static Connection connect() { 
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapplicationproject","root","root");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
		
	}
}
	
