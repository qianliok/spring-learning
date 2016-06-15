package com.github.sebin.chapter03.dao;

import com.github.sebin.chapter03.Account;

public interface AccountDAO {
	Account findById(int accountID);
	void credit(Account account);
	void debit(Account account);
}
