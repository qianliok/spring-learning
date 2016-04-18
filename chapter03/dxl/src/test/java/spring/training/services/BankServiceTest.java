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
import spring.training.model.TransactionStatus;
import spring.training.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test.xml" })
public class BankServiceTest {

	@Autowired
	BankService bankService;
	@Autowired
	User user;

	@Test
	public void testDebitOk() {
		Account account = user.getAccounts()[0];
		assertEquals( "There should be no transaction when we start...", 0, account.getAccountTransactions().size());
		assertEquals( "Debit: success!", TransactionStatus.SUCCESS, (bankService.debit( account, new BigDecimal( 10 )).getStatus()));
		assertEquals( "Current balance: ok!", new BigDecimal( 40 ), account.getAccountBalance() );
		assertEquals( "Credit: success!", TransactionStatus.SUCCESS, (bankService.credit( account, new BigDecimal( 20 )).getStatus()));
		assertEquals( "Current balance: ok!", new BigDecimal( 60 ), account.getAccountBalance() );
	}

	@Test
	public void testCreditBad() {
		Account account = user.getAccounts()[0];
		assertEquals(TransactionStatus.FAILURE, (bankService.credit( account, new BigDecimal( 150 )).getStatus()));
	}

	@Test
	public void testDebitBad() {
		Account account = user.getAccounts()[0];
		assertEquals(TransactionStatus.FAILURE, (bankService.debit( account, new BigDecimal( 150 )).getStatus()));
	}

}
