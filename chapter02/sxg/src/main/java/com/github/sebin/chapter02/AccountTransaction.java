package com.github.sebin.chapter02;

import java.util.Calendar;

public class AccountTransaction {
	private int fromAccountId;
	private int toAccountId;
	private int amount;
	private Calendar time;
	/**
	 * @param fromAccountId
	 * @param toAccountId
	 * @param amount
	 * @param time
	 */
	public AccountTransaction(int fromAccountId, int toAccountId, int amount, Calendar time) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.time = time;
	}
	/**
	 * @return the fromAccountId
	 */
	public int getFromAccountId() {
		return fromAccountId;
	}
	/**
	 * @return the toAccountId
	 */
	public int getToAccountId() {
		return toAccountId;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @return the time
	 */
	public Calendar getTime() {
		return time;
	}
	
	

}
