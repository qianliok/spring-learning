package com.github.sebin.chapter03;

import java.util.Calendar;

public class AccountTransaction {
	private double amount;
	private Calendar time;
	private Account fromAccount;
	private Account toAccount;
	/**
	 * @param fromAccountId
	 * @param toAccountId
	 * @param amount
	 * @param time
	 */
	public AccountTransaction(final Account fromAccount,
			final  Account toAccount,
			final  double amount,
			final  Calendar time) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.time = time;
	}
	/**
	 * @return the fromAccount
	 */
	public Account getFromAccount() {
		return fromAccount;
	}
	/**
	 * @return the toAccountId
	 */
	public Account getToAccount() {
		return toAccount;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @return the time
	 */
	public Calendar getTime() {
		return time;
	}

}
