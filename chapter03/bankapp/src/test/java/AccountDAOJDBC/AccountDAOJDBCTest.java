package AccountDAOJDBC;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.training.dao.AccountDAO;
import spring.training.model.Account;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "/test.xml" } )
@DirtiesContext( classMode = ClassMode.AFTER_EACH_TEST_METHOD )
public class AccountDAOJDBCTest {

	@Autowired
	AccountDAO accountDAO;
	
	@Test 
	public void testUpdateAccountBalance() throws Exception {
		Account account = new Account( 60000, 50000, "joe_p0", new BigDecimal( 13 ), new BigDecimal( 100 ));
		accountDAO.updateAccountBalance( account );
		assertEquals("13", accountDAO.checkAccountBalance(60000L));
	}
	
	@Test
	public void testCheckAccountBalance() throws Exception {
		assertEquals("15.00", accountDAO.checkAccountBalance(60000L));
	}
}
