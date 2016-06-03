
package spring.training.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.training.exception.BankException;
import spring.training.model.Account;
import spring.training.model.User;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "/test.xml" } )
@DirtiesContext( classMode = ClassMode.AFTER_EACH_TEST_METHOD )
public class BankServiceTest {

	@Autowired
	BankService bankService;

	@Autowired
	User user;

	@Test
	public void testDebitOk() throws BankException {
		Account x = user.getAccounts().get( 0 );
		assertEquals( "transactions should be empty before load", 0, x.getAccountTransactions().size() );
		assertTrue( "transaction success", bankService.debit( x, new BigDecimal( 2 ) ) );
		assertEquals( new BigDecimal( -2 ), x.getAccountTransactions().get( 0 ).getAmount() );
	}

	@Test
	public void testCreditOk() throws BankException {
		Account x = user.getAccounts().get( 0 );
		assertEquals( "transactions should be empty before load", 0, x.getAccountTransactions().size() );
		assertTrue( "transaction success", bankService.credit( x, new BigDecimal( 2 ) ) );
		assertEquals( new BigDecimal( 2 ), x.getAccountTransactions().get( 0 ).getAmount() );
	}

	@Test (expected = BankException.class)
	public void testCreditBad() throws BankException {
		Account x = user.getAccounts().get( 0 );
		assertFalse( "transaction success", bankService.credit( x, new BigDecimal( 50 ) ) );
	}

	@Test(expected = BankException.class)
	public void testDebitBad() throws BankException {
		Account x = user.getAccounts().get( 0 );
		assertFalse( "transaction success", bankService.debit( x, new BigDecimal( 50 ) ) );
	}

}
