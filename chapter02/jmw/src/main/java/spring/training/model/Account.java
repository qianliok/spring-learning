
package spring.training.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Account {

	public Account( long accountID, long customerID, String accountDescription, BigDecimal accountBalance, BigDecimal accountMaxBalance ) {
		super();
		this.accountID = accountID;
		this.customerID = customerID;
		this.accountDescription = accountDescription;
		this.accountBalance = accountBalance;
		this.accountMaxBalance = accountMaxBalance;

		this.accountTransactions = new LinkedList<>();
	}

	private long accountID;
	private long customerID;
	private String accountDescription;
	private BigDecimal accountBalance;
	private BigDecimal accountMaxBalance;

	// there's potential to debate if this is the best collection type.
	private List<AccountTransaction> accountTransactions;

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID( long accountID ) {
		this.accountID = accountID;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID( long customerID ) {
		this.customerID = customerID;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription( String accountDescription ) {
		this.accountDescription = accountDescription;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance( BigDecimal accountBalance ) {
		this.accountBalance = accountBalance;
	}

	public BigDecimal getAccountMaxBalance() {
		return accountMaxBalance;
	}

	public void setAccountMaxBalance( BigDecimal accountMaxBalance ) {
		this.accountMaxBalance = accountMaxBalance;
	}

	public List<AccountTransaction> getAccountTransactions() {
		return accountTransactions;
	}

	public void setAccountTransactions( List<AccountTransaction> accountTransaction ) {
		this.accountTransactions = accountTransaction;
	}

	public void addTransaction( AccountTransaction txn ) {
		this.accountTransactions.add( txn );
	}

}
