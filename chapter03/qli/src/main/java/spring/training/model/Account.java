package spring.training.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int accountNumber;
	private String accountDescription;
	private double accountAmount;
	private Customer customer;
	
	public final static double MAX_AMOUNT = 100000000;

	private List<AccountTranscation> transactions = new ArrayList<>();
	
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public Account setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public Account setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
		return this;
	}

	public double getAccountAmount() {
		return accountAmount;
	}

	public Account setAccountAmount(double accountAmount) {
		this.accountAmount = accountAmount;
		return this;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Account setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	public List<AccountTranscation> getTransactions() {
		return transactions;
	}

	public boolean recordTransactions(AccountTranscation txn) {
		if( txn != null){		
			boolean sccess = applyTransaction(txn.getApplyAmount(this));
			if( sccess ){
				this.transactions.add(txn);
				return true;
			}else{
				return false;
			}
		}
		
		return false;
	}
	
	public boolean validateTransaction(double amount){
		double newAmount = this.accountAmount + amount;		
		if(  newAmount < 0 || newAmount > MAX_AMOUNT ){
			return false;
		}else{
			return true;
		}
	}
	
	private boolean applyTransaction(double amount){
		if( validateTransaction(amount) ){
			this.accountAmount += amount;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		return true;
	}

}
