package spring.training.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import spring.training.model.Account;

public class PxdBankServiceTest {

	@Autowired
	PxdBankService bank;
	
	@Test
	public void testSuccessfulDebit() {
	  //TODO

	}

	@Test
	public void testSuccessfulCredit() {
		fail("Not yet implemented");
	}

}
