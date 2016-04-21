package spring.training.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.training.model.Account;
import spring.training.model.Customer;
import spring.training.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test.xml" })
public class SpringBankServiceTest {

	@Autowired
	SpringBankService service;

	@Autowired
	@Qualifier("testuser")
	User testuser;

	@Autowired
	@Qualifier("qli")
	Customer qli;

	@Autowired
	@Qualifier("acc00000001")
	Account acc00000001;

	@Autowired
	@Qualifier("acc00000002")
	Account acc00000002;

	@Before
	public void setup() {
		assertNotNull(service);
		assertNotNull(testuser);
		assertNotNull(qli);
		assertNotNull(acc00000001);
		assertNotNull(acc00000002);

//		qli.addAcount(acc00000001);
//		qli.addAcount(acc00000002);
	}

	@After
	public void reset() {
		acc00000001.setAccountAmount(1000);
		acc00000002.setAccountAmount(100);
	}

	@Test
	public void debitTest() {
		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 100, 0.01);

		assertTrue(service.debit(testuser, acc00000001, acc00000002, 50));

		assertEquals(acc00000001.getAccountAmount(), 950, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 150, 0.01);

	}
	
	@Test
	public void debit3ParamTest() {
		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);

		assertTrue(service.debit(testuser, acc00000001, 50));

		assertEquals(acc00000001.getAccountAmount(), 950, 0.01);

	}

	@Test
	public void creditTest() {
		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 100, 0.01);

		assertTrue(service.credit(testuser, acc00000001, acc00000002, 50));

		assertEquals(acc00000001.getAccountAmount(), 1050, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 50, 0.01);

	}
	
	@Test
	public void credit3ParamTest() {
		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);

		assertTrue(service.credit(testuser, acc00000001, 50));

		assertEquals(acc00000001.getAccountAmount(), 1050, 0.01);
	}

	@Test
	public void debitErrorTest() {
		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 100, 0.01);

		// Insufficient fund in acc00000001
		assertFalse(service.debit(testuser, acc00000001, acc00000002, 1050));

		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 100, 0.01);
		
		// Test acc00000002 over the max limit
		acc00000002.setAccountAmount(Account.MAX_AMOUNT-10);
		assertFalse(service.debit(testuser, acc00000001, acc00000002, 50));		
		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);
		assertEquals(acc00000002.getAccountAmount(), Account.MAX_AMOUNT-10, 0.01);
		
		try {
			service.debit(testuser, acc00000001, acc00000002, -100);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Invalid transaction amount");
		}

		
		try {
			service.debit(null, acc00000001, acc00000002, 100);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Un-authorised user");
		}
		
		assertFalse( service.debit(testuser, null, null, 100) );
	}
	
	@Test
	public void creditErrorTest() {
		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 100, 0.01);

		// Insufficient fund in acc00000002 
		assertFalse(service.credit(testuser, acc00000001, acc00000002, 105));

		assertEquals(acc00000001.getAccountAmount(), 1000, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 100, 0.01);
		
		
		// Test acc00000001 over the max limit
		acc00000001.setAccountAmount(Account.MAX_AMOUNT-10);
		assertFalse(service.credit(testuser, acc00000001, acc00000002, 50));		
		assertEquals(acc00000001.getAccountAmount(), Account.MAX_AMOUNT-10, 0.01);
		assertEquals(acc00000002.getAccountAmount(), 100, 0.01);

		try {
			service.credit(testuser, acc00000001, acc00000002, -100);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Invalid transaction amount");
		}

		
		try {
			service.credit(null, acc00000001, acc00000002, 100);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Un-authorised user");
		}
		
		assertFalse( service.credit(testuser, null, null, 100) );
	}
}
