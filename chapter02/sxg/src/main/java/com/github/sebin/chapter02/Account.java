package com.github.sebin.chapter02;

public class Account {
	private int accountID;
	private User customer;
	private String accountDescription;
	private double accountBalance;
	private double accountMaxBalance;
	
	
	/**
	 * @param accountID
	 * @param customer
	 * @param accountDescription
	 * @param accountBalance
	 * @param accountMaxBalance
	 */
	public Account(int accountID, User customer, String accountDescription, double accountBalance,
			double accountMaxBalance) {
		super();
		this.accountID = accountID;
		this.customer = customer;
		this.accountDescription = accountDescription;
		this.accountBalance = accountBalance;
		this.accountMaxBalance = accountMaxBalance;
	}


	/**
	 * @return the accountBalance
	 */
	public double getAccountBalance() {
		return accountBalance;
	}


	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	/**
	 * @return the accountMaxBalance
	 */
	public double getAccountMaxBalance() {
		return accountMaxBalance;
	}


	/**
	 * @param accountMaxBalance the accountMaxBalance to set
	 */
	public void setAccountMaxBalance(double accountMaxBalance) {
		this.accountMaxBalance = accountMaxBalance;
	}


	/**
	 * @return the accountID
	 */
	public int getAccountID() {
		return accountID;
	}


	/**
	 * @return the customer
	 */
	public User getCustomer() {
		return customer;
	}


	/**
	 * @return the accountDescription
	 */
	public String getAccountDescription() {
		return accountDescription;
	}

}
