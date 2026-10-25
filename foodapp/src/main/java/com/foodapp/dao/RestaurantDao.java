package com.foodapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.Restaurant;

public interface RestaurantDao {

	int insert(Restaurant r);
	ArrayList<Restaurant> fetchAll();
	public List<Restaurant> getAllRestaurants() throws Exception;
	Restaurant fetchOne(int restaurantid);
	int update(int restaurantId,String name);
	int delete(int restaurantId);
}
