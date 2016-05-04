package com.github.sebin.chapter03;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.sebin.chapter03.Account;
import com.github.sebin.chapter03.service.BankService;
import com.github.sebin.chapter03.service.impl.XBank;

@Configuration
public class BankConfig {

	@Bean
	public Audit audit() {
		return new Audit();
	}
	
	@Bean
	public Counter auditCounter(){
		return new Counter();
	}
	
	@Bean
	public User user() {
		return new User(1, "xbxlnv5", "123456", "My Name");
	}


	@Bean
	public Account fromAccount() {
		return new Account(1, user(), "Testing account 1", 10, 100000);
	}

	@Bean
	public Account toAccount() {
		return new Account(2, user(), "Testing account 2", 100, 10000);
	}
	
	@Bean
	public BankService bank() {
		Set<Account> accounts = new HashSet<Account>();
		accounts.add(fromAccount());
		accounts.add(toAccount());
		XBank bank = new XBank();
		bank.setAccounts(accounts);
		return bank;
	}	
}
