package com.github.sebin.chapter03;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sebin.chapter03.service.BankService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:context.xml" })
public class BankServiceTest {
	
	@Autowired
    private ApplicationContext context;
	
	@Test
	public void canCreditAmount() {
		BankService bank = (BankService)context.getBean("bank");
		Account account = (Account)context.getBean("fromAccount");
		account.setAccountBalance(100);
		double initValue = account.getAccountBalance();
		double amount = 100;
		if(account.getAccountMaxBalance() > (initValue+amount) ){
			bank.credit(new AccountTransaction(account, null, amount, Calendar.getInstance()));
			Assert.assertEquals(account.getAccountBalance(),(initValue+amount),0);
		}
	}

	@Test(expected=IllegalStateException.class)
	public void canLimitCreditAmount() {
		BankService bank = (BankService)context.getBean("bank");
		Account account = (Account)context.getBean("fromAccount");
		double amount = account.getAccountMaxBalance()+1;
		bank.credit(new AccountTransaction(account, null, amount, Calendar.getInstance()));
	}

	@Test
	public void canDeditAmount() {
		BankService bank = (BankService)context.getBean("bank");
		Account account = (Account)context.getBean("fromAccount");
		account.setAccountBalance(100);
		double initValue = account.getAccountBalance();
		double amount = 5;
		if( (initValue-amount)>=0){
			bank.debit(new AccountTransaction(account, null, amount, Calendar.getInstance()));
			Assert.assertEquals(account.getAccountBalance(),(initValue-amount),0);
		}
	}

	@Test(expected=IllegalStateException.class)
	public void canLimitDeditAmount() {
		BankService bank = (BankService)context.getBean("bank");
		Account account = (Account)context.getBean("fromAccount");
		double amount = account.getAccountBalance();
		bank.debit(new AccountTransaction(account, null, amount+1, Calendar.getInstance()));
	}

}
