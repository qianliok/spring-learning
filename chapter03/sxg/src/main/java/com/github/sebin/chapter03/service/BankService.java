package com.github.sebin.chapter03.service;

import com.github.sebin.chapter03.AccountTransaction;

public interface BankService {
	void debit(AccountTransaction transaction);
	void credit(AccountTransaction transaction);
}
