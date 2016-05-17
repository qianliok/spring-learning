
package spring.training.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring.training.exception.BankException;
import spring.training.model.Account;
import spring.training.model.AccountTransaction;
import spring.training.services.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	@Qualifier( "minBalance" )
	BigDecimal minBalance;

	/* (non-Javadoc)
	 * @see spring.training.services.BankInterface#debit(spring.training.model.Account, java.math.BigDecimal)
	 */
	@Override
	public boolean debit( Account toAccount, BigDecimal amount ) throws BankException {
		boolean success = false;
		BigDecimal newBalance = toAccount.getAccountBalance().subtract( amount );
		if ( newBalance.compareTo( minBalance ) > 0 ) {
			toAccount.setAccountBalance( newBalance );
			toAccount.addTransaction( new AccountTransaction( null, toAccount.getAccountID(), amount.negate(), getTime() ) );
			success = true;
		} else {
			throw new BankException("unable to debit beyond minimum balance");
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see spring.training.services.BankInterface#credit(spring.training.model.Account, java.math.BigDecimal)
	 */
	@Override
	public boolean credit( Account toAccount, BigDecimal amount ) throws BankException {
		boolean success = false;
		BigDecimal newBalance = toAccount.getAccountBalance().add( amount );
		if ( newBalance.compareTo( toAccount.getAccountMaxBalance() ) < 0 ) {
			toAccount.setAccountBalance( newBalance );
			// bad to use System time but we'll forget about that.
			toAccount.addTransaction( new AccountTransaction( null, toAccount.getAccountID(), amount, getTime() ) );
			success = true;
		} else {
			throw new BankException("unable to debut beyond minimum balance");
		}
		return success;
	}

	/**
	 * placeholder because this is bad practice
	 * 
	 * @return
	 */
	public long getTime() {
		return System.currentTimeMillis();
	}
}
