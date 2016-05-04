package com.github.sebin.chapter03.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.github.sebin.chapter03.Account;
import com.github.sebin.chapter03.AccountTransaction;
import com.github.sebin.chapter03.service.BankService;

public class XBank implements BankService {
	
	private Set<Account> accounts = new HashSet<Account>();
	

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void debit(final AccountTransaction transaction) {
		if(transaction.getFromAccount() == null ||
				!accounts.contains(transaction.getFromAccount())){
			throw new IllegalStateException("Trouble in banking with account:"+transaction.getFromAccount());
		}
		if( (transaction.getFromAccount().getAccountBalance()-transaction.getAmount())>=0){
			if(transaction.getToAccount() != null){ // If to account is null, it is not an account to account transaction.
				if(accounts.contains(transaction.getToAccount())){
					throw new IllegalStateException("Trouble in banking with account:"+transaction.getToAccount());
				}
				
				transaction.getToAccount().setAccountBalance(
						transaction.getToAccount().getAccountBalance()+transaction.getAmount());
			}
			transaction.getFromAccount().setAccountBalance(
					transaction.getFromAccount().getAccountBalance()-transaction.getAmount());
		}else{
			throw new IllegalStateException("Not enough money!");
		}
		
	}

	public void credit(final AccountTransaction transaction) {
		if(transaction.getFromAccount() == null ||
				!accounts.contains(transaction.getFromAccount())){
			throw new IllegalStateException("Trouble in banking with account:"+transaction.getFromAccount());
		}
		if( (transaction.getFromAccount().getAccountBalance()-transaction.getAmount())>=0){
			if(transaction.getToAccount() != null){ // If to account is null, it is not an account to account transaction.
				if(accounts.contains(transaction.getToAccount())){
					throw new IllegalStateException("Trouble in banking with account:"+transaction.getToAccount());
				}
				
				transaction.getToAccount().setAccountBalance(
						transaction.getToAccount().getAccountBalance()-transaction.getAmount());
			}
			transaction.getFromAccount().setAccountBalance(
					transaction.getFromAccount().getAccountBalance()+transaction.getAmount());
		}else{
			throw new IllegalStateException("Too Much Money!");
		}
	}

}
