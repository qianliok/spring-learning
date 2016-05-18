package spring.training.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import spring.training.model.Account;
import spring.training.services.AccountService;

public class AccountServiceImpl implements AccountService {

	@Autowired
	Map <String, Account> accounts;
	
	public AccountServiceImpl( Map<String, Account> accounts ) {
		super();
		this.accounts = accounts;
	}



	@Override
	public Account getAccount( String accountId ) {
		return accounts.get( accountId );
	}

}
