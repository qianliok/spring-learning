package spring.training.model;

public class User {

	public User( String username, Long customerID, String password, String fullname, Account[] accounts ) {
		super();
		this.username = username;
		this.customerID = customerID;
		this.password = password;
		this.fullname = fullname;
		this.accounts = accounts;
	}

	private String username;
	private Long customerID;
	private String password;
	private String fullname;

	private Account[] accounts;

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername( String username ) {
		this.username = username;
	}

	
	public Long getCustomerID() {
		return customerID;
	}

	
	public void setCustomerID( Long customerID ) {
		this.customerID = customerID;
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
