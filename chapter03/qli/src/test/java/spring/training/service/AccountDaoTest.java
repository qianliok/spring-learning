package spring.training.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.training.dao.AccountDao;
import spring.training.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-dao.xml" })
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountDaoTest {

	@Autowired
	AccountDao accountDao;

	@Test
	public void testUpdateAccountBalance() throws Exception {
		Account account = new Account().setAccountNumber(10000002)
				.setAccountAmount(2000);
		accountDao.updateAccountBalance(account);
		assertEquals("2000.00", accountDao.checkAccountBalance(10000002));
	}

	@Test
	public void testCheckAccountBalance() throws Exception {
		assertEquals("100.00", accountDao.checkAccountBalance(10000002));
	}
	
	@Test
	public void testSelectAccount() {
		Account acc = accountDao.selectAccount(10000001);
		
		assertEquals(10000001, acc.getAccountNumber() );
		assertEquals("test account 1", acc.getAccountDescription() );
		assertEquals( 1000, acc.getAccountAmount(), 0.01);
	}
	
}
