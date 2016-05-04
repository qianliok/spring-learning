package com.github.sebin.chapter02;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.sebin.chapter02.service.BankService;

public class BankServiceTest {
	

	
	@Test
	public void canCreditAmount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		BankService bank = (BankService)context.getBean("bank");
		Account account = (Account)context.getBean("account");
		double initValue = account.getAccountBalance();
		double amount = 100;
		if(account.getAccountMaxBalance() > (initValue+amount) ){
			bank.credit(account, amount);
			Assert.assertEquals(account.getAccountBalance(),(initValue+amount),0);
		}else{
			Assert.assertTrue(false); // can't test, there is too much money.
		}
	}

	@Test(expected=IllegalStateException.class)
	public void canLimitCreditAmount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		BankService bank = (BankService)context.getBean("bank");
		Account account = (Account)context.getBean("account");
		double amount = account.getAccountMaxBalance()+1;
		bank.credit(account, amount);
	}

	@Test
	public void canDeditAmount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		BankService bank = (BankService)context.getBean("bank");
		Account account = (Account)context.getBean("account");
		double initValue = account.getAccountBalance();
		double amount = 5;
		if( (initValue-amount)>=0){
			bank.debit(account, amount);
			Assert.assertEquals(account.getAccountBalance(),(initValue-amount),0);
		}else{
			Assert.assertTrue(false); // can't test, there is not enough money.
		}
	}

	@Test(expected=IllegalStateException.class)
	public void canLimitDeditAmount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		BankService bank = (BankService)context.getBean("bank");
		Account account = (Account)context.getBean("account");
		double amount = account.getAccountBalance();
		bank.debit(account, amount+1);
	}

}
