package spring.training.model;

import java.math.BigDecimal;

public class AccountTransaction {

	private Long fromAccountID;
	private Long toAccountID;
	private BigDecimal amount;
	private long time;
	
	public AccountTransaction( Long fromAccountID, Long toAccountID, BigDecimal amount, long time ) {
		super();
		this.fromAccountID = fromAccountID;
		this.toAccountID = toAccountID;
		this.amount = amount;
		this.time = time;
	}

	public long getFromAccountID() {
		return fromAccountID;
	}
	
	public void setFromAccountID( Long fromAccountID ) {
		this.fromAccountID = fromAccountID;
	}
	
	public Long getToAccountID() {
		return toAccountID;
	}
	
	public void setToAccountID( long toAccountID ) {
		this.toAccountID = toAccountID;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount( BigDecimal amount ) {
		this.amount = amount;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime( long time ) {
		this.time = time;
	}
	
}
