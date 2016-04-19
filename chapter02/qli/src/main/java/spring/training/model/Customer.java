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

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}

	public void addAcount(Account account) {		
		if (account != null && accounts.get(account.getAccountNumber()) == null) {
			accounts.put(account.getAccountNumber(), account);
		}
	}
}
