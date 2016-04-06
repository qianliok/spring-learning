package spring.training.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.training.model.Account;
import spring.training.model.User;
import spring.training.services.BankService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test.xml" })
public class BankServiceTest {

	@Autowired
	BankService bankService;
	
	@Autowired
	User user;
	
	@Test
	public void testDebitOk() {
		Account x = user.getAccounts()[0];
		assertEquals( "transactions should be empty before load", 0, x.getAccountTransactions().size());
		assertTrue("transaction success", bankService.debit( x, new BigDecimal( 2 ) ));
		assertEquals( new BigDecimal( -2 ), x.getAccountTransactions().get( 0 ).getAmount() );
		assertTrue("transaction success", bankService.credit( x, new BigDecimal( 2 ) ));
		assertEquals( new BigDecimal( 2 ), x.getAccountTransactions().get( 1 ).getAmount() );
	}
	
	@Test
	public void testCreditBad() {
		Account x = user.getAccounts()[0];
		assertFalse("transaction success", bankService.credit( x, new BigDecimal( 50 ) ));
	}
	
	@Test
	public void testDebitBad() {
		Account x = user.getAccounts()[0];
		assertFalse("transaction success", bankService.debit( x, new BigDecimal( 50 ) ));
	}

}
