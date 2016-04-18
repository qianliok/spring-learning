package spring.training.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	private Long customerID;
	private String username;
	private String password;
	private String fullname;
	private Account[] accounts;

	public User( String username, Long customerID, String password, String fullname, Account[] accounts ) {
		super();
		this.username = username;
		this.customerID = customerID;
		this.password = password;
		this.fullname = fullname;
		this.accounts = accounts;
	}


	public Long getCustomerID() {
		return customerID;
	}


	public void setCustomerID( Long customerID ) {
		this.customerID = customerID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername( String username ) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword( String password ) {
		this.password = password;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname( String fullname ) {
		this.fullname = fullname;
	}


	public Account[] getAccounts() {
		return accounts;
	}


	public void setAccounts( Account[] accounts ) {
		this.accounts = accounts;
	}

}
