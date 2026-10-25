package com.foodapp.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.connect.DBConnect;
import com.foodapp.dao.UserDao;
import com.foodapp.model.User;

public class UserDaoImpl implements UserDao {
	
	private static Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private User user;
	
	private final static String insertQuery="insert into user(name,UserName,email,phone,password,address) values(?,?,?,?,?,?)";
	private final static String fetchAll="select * from user";
	private final static String fetchOne="select * from user where userId=?";
	private final static String update="update user set password=? where userId=?";
	private final static String delete="delete from user where userId=?";
	private final static String fetch="select * from user where email=? and password=?";
	private final static String query1 = "SELECT * FROM user WHERE email = ?";
	private final static String fetchOne1 = "SELECT * FROM user WHERE userName = ?";
	
	private static ArrayList<User> arr = new ArrayList<User>();
	private static ArrayList<User> one = new ArrayList<User>();

	//Database connection
	static {
		
		try {
			con = DBConnect.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	//insert into DataBase
	@Override
	public int insert(User u) {
		
		try{
			pstmt=con.prepareStatement(insertQuery);
			//pstmt.setInt(1,u.getUserId());
			pstmt.setString(1,u.getName());
			pstmt.setString(2,u.getUserName());
			pstmt.setString(3,u.getEmail());
			pstmt.setString(4,u.getPhone());
			pstmt.setString(5,u.getPassword());
			pstmt.setString(6,u.getAddress());
			
			return pstmt.executeUpdate();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
	
	
	//Fetch All
	@Override
	public ArrayList<User> fetchAll() {
		
		
		try
		{
			stmt = con.createStatement();
			resultSet=stmt.executeQuery(fetchAll);

			while(resultSet.next()) {
				arr.add(new User(resultSet.getInt("userId"),
						resultSet.getString("name"),
						resultSet.getString("userName"),
						resultSet.getString("email"),
						resultSet.getString("phone"),
						resultSet.getString("password"),
						resultSet.getString("address")
						));
			}

		} 

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return arr;
	}

	
	
	//fetch one
	@Override
	public User fetchOne(int userId) {

		try 
		{
			pstmt=con.prepareStatement(fetchOne);
			pstmt.setInt(1,userId);
			ResultSet resultSet = pstmt.executeQuery();
				
		
			while(resultSet.next()) {
				one.add(new User(resultSet.getInt("userId"),
						resultSet.getString("name"),
						resultSet.getString("userName"),
						resultSet.getString("email"),
						resultSet.getString("phone"),
						resultSet.getString("password"),
						resultSet.getString("address")
						));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return one.get(0);
		
	}

	
	//Update record
	@Override
	public int update(int userId, String password) {
		
		try
		{
			pstmt=con.prepareStatement(update);
			pstmt.setInt(2,userId);
			pstmt.setString(1, password);
			
			return pstmt.executeUpdate();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	
	
	//delete record
	@Override
	public int delete(int userId) {
		
		try
		{
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1,userId);
			
			return pstmt.executeUpdate();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}




	@Override
	public boolean validateUser(String email,String password) {
		boolean isValid = false;
		try 
		{
			pstmt=con.prepareStatement(fetch);
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			ResultSet rs = pstmt.executeQuery();
				System.out.println("hello");
			if (rs.next()) {
				
				isValid = true;
				System.out.println("no");
				
			}
			//con.close(); 
			
		} catch (Exception e){
			e.printStackTrace(); 
			
		} 
		return isValid;	
		
	}




	@Override
	public String fetchUsernameByEmail(String email) {
		//System.out.println("Email: " + email);
		
		String username = "";
		try {
			//System.out.println("try: " + email);
			PreparedStatement pstmt = con.prepareStatement(query1);
            pstmt.setString(1, email);
            //System.out.println("pstmt: " + email);
            ResultSet rs = pstmt.executeQuery();
            //System.out.println("exe: " + email);
            if (rs.next()) {
            	//System.out.println("next: " + email);
                username= rs.getString("userName");
            }
        }
		catch (Exception e) {
            e.printStackTrace();
        }
        return username;
	}
	
	
	
	public User fetchUserByUsername(String username) {

		try 
		{
			pstmt=con.prepareStatement(fetchOne1);
			pstmt.setString(1,username);
			ResultSet resultSet = pstmt.executeQuery();
				
		
			while(resultSet.next()) {
				one.add(new User(resultSet.getInt("userId"),
						resultSet.getString("name"),
						resultSet.getString("userName"),
						resultSet.getString("email"),
						resultSet.getString("phone"),
						resultSet.getString("password"),
						resultSet.getString("address")
						));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return one.get(0);
		
	}
			
}

