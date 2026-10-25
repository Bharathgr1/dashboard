package com.foodapp.model;

public class User {
	
	private int userId;
	private String name;
	private String userName;
	private String email;
	private String phone;
	private String password;
	private String address;
	
	
	public User(int userId, String name, String userName, String email, String phone, String password, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
	}
	
	public User( String name, String userName, String email, String phone, String password, String address) {
		super();
//		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return  userId +"  "+ name + " " + userName + " " + email + " " + phone + " " + password + " " + address;
	}
	
}
