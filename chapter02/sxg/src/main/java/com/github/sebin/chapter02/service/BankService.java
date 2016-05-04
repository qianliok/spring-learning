package com.github.sebin.chapter02.service;

import com.github.sebin.chapter02.Account;

public interface BankService {
	void debit(Account account, double amount);
	void credit(Account account, double amount);
}
