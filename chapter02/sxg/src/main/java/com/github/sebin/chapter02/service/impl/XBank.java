package com.github.sebin.chapter02.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.github.sebin.chapter02.Account;
import com.github.sebin.chapter02.service.BankService;

public class XBank implements BankService {
	
	private Set<Account> accounts = new HashSet<Account>();
	

	/**
	 * @param accounts
	 */
	public XBank(Set<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public void debit(Account account, double amount) {
		if( (account.getAccountBalance()-amount)>=0){
			account.setAccountBalance(account.getAccountBalance()-amount);
		}else{
			throw new IllegalStateException("Not enough money!");
		}
	}

	public void credit(Account account, double amount) {
		if( (account.getAccountBalance()+amount)<account.getAccountMaxBalance()){
			account.setAccountBalance(account.getAccountBalance()+amount);
		}else{
			throw new IllegalStateException("Too Much Money!");
		}

	}

}
