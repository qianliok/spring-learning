package com.github.sebin.chapter03;

public class User {
	private int customerID;
	private String username;
	private String password;
	private String fullname;
	
	/**
	 * @param customerID
	 * @param username
	 * @param password
	 * @param fullname
	 */
	public User(final int customerID, 
			final String username, 
			final String password, 
			final String fullname) {
		super();
		this.customerID = customerID;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}
	public int getCustomerID() {
		return customerID;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFullname() {
		return fullname;
	}
	
	
}
