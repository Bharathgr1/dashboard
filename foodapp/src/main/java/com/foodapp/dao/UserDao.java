package com.foodapp.dao;

import java.util.ArrayList;
import com.foodapp.model.User;

public interface UserDao {
	
	int insert(User u);
	ArrayList<User> fetchAll();
	User fetchOne(int userId);
	int update(int userId,String password);
	int delete(int userId);
	boolean validateUser(String email,String password);
	String fetchUsernameByEmail(String email);
	User fetchUserByUsername(String username);
}
