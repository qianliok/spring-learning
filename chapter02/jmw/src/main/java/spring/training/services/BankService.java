
package spring.training.services;

import java.math.BigDecimal;

import spring.training.model.Account;
import spring.training.model.AccountTransaction;

public class BankService {

	static BigDecimal minBalance = new BigDecimal( 0 );

	public boolean debit( Account toAccount, BigDecimal amount ) {
		boolean success = false;
		BigDecimal newBalance = toAccount.getAccountBalance().subtract( amount );
		if ( newBalance.compareTo( minBalance ) > 0 ) {
			toAccount.setAccountBalance( newBalance );
			toAccount.addTransaction( new AccountTransaction( null, toAccount.getAccountID(), amount.negate(), getTime() ) );
			success = true;
		}
		return success;
	}

	public boolean credit( Account toAccount, BigDecimal amount ) {
		boolean success = false;
		BigDecimal newBalance = toAccount.getAccountBalance().add( amount );
		if ( newBalance.compareTo( toAccount.getAccountMaxBalance() ) < 0 ) {
			toAccount.setAccountBalance( newBalance );
			// bad to use System time but we'll forget about that.
			toAccount.addTransaction( new AccountTransaction( null, toAccount.getAccountID(), amount, getTime()) );
			success = true;
		}
		return success;
	}

	/**
	 * placeholder because this is bad practice
	 * @return
	 */
	public long getTime() {
		return System.currentTimeMillis();
	}
}
