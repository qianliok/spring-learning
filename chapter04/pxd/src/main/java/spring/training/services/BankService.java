
package spring.training.services;

import java.math.BigDecimal;

import spring.training.exception.BankException;
import spring.training.model.Account;

public interface BankService {

	/**
	 * debit an account
	 * @param toAccount
	 * @param amount
	 * @return
	 * @throws BankException 
	 */
	boolean debit( Account toAccount, BigDecimal amount ) throws BankException;
	
	/**
	 * 
	 * @param toAccount
	 * @param amount
	 * @return
	 * @throws BankException 
	 */
	boolean credit( Account toAccount, BigDecimal amount ) throws BankException;
}
