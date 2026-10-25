package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.connect.DBConnect;
import com.foodapp.dao.RestaurantDao;
import com.foodapp.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {

	
	private Statement stmt;
	private static Connection con;
	private ResultSet resultSet;
	
	
	private final static String fetchAll="select * from restuarant";
	//String query = "SELECT * FROM restaurent";
	
	
	
	private static List<Restaurant> restaurantList = new ArrayList<>();
	private static ArrayList<Restaurant> arr = new ArrayList<Restaurant>();

	static {

		try {
			con = DBConnect.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	
	
	//fetchAll
	@Override
	public int insert(Restaurant r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Restaurant> fetchAll() {

		try
		{
			stmt = con.createStatement();
			resultSet=stmt.executeQuery(fetchAll);

			while(resultSet.next()) {
				arr.add(new Restaurant(resultSet.getInt("restaurantId"),
						resultSet.getString("name"),
						resultSet.getString("cuisineType"),
						resultSet.getInt("deliveryTime"),
						resultSet.getString("address"),
						resultSet.getFloat("ratings"),
						resultSet.getByte("isActive"),
						resultSet.getString("imagePath")
						));
			}
		} 

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return arr;
	}
		
	

	@Override
	public Restaurant fetchOne(int restaurantid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int restaurantId, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int restaurantId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Restaurant> getAllRestaurants() throws Exception {

		
		 try (Statement stmt = con.createStatement();
				 
				 ResultSet rs = stmt.executeQuery(fetchAll)) {
	            while (rs.next()) {
	            	Restaurant restaurant = new Restaurant();
	                restaurant.setRestaurantId(rs.getInt("restaurantId"));
	                restaurant.setName(rs.getString("Name"));
	                restaurant.setCuisineType(rs.getString("cuisineType"));
	                restaurant.setDeliveryTime(rs.getInt("DeliveryTime"));
	                restaurant.setAddress(rs.getString("address"));
	                restaurant.setRatings(rs.getFloat("ratings"));
	                restaurant.setIsActive(rs.getByte("isActive"));
	                restaurant.setImagePath(rs.getString("imagePath"));
	                
	               // System.out.println(restaurant);

	                restaurantList.add(restaurant);
	            }
	        }
	        return restaurantList;
	}
	
}
