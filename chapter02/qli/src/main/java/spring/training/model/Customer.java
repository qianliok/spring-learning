package spring.training.model;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User {
	private String customerID;
	private String name;
	private Map<Integer, Account> accounts = new HashMap<>();

	public String getCustomerID() {
		return customerID;
	}

	public Customer setCustomerID(String customerID) {
		this.customerID = customerID;
		return this;
	}

	public String getName() {
		return name;
	}

	public Customer setName(String name) {
		this.name = name;
		return this;
	}

	public Map<Integer, Account> getAccounts() {
		return accounts;
	}

	public Customer setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
		return this;
	}

	public Customer addAcount(Account account) {		
		if (account != null && accounts.get(account.getAccountNumber()) == null) {
			accounts.put(account.getAccountNumber(), account);
		}
		return this;
	}
	
	public Customer setUser(User user){
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		return this;
	}
}
