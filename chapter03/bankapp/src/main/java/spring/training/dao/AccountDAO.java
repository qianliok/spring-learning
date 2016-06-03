package spring.training.dao;

import spring.training.model.Account;

public interface AccountDAO {

	/**
	 * update account balance
	 * @param account
	 * @return
	 */
	Account updateAccountBalance( Account account );
	
	/**
	 * just something to test database functionality works
	 * @param accountID
	 * @return
	 */
	Object checkAccountBalance( long accountID );
}
