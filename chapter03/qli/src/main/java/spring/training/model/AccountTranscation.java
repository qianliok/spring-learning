package spring.training.model;

public class AccountTranscation {
	private Account fromAccount;
	private Account toAccount;
	private double amount;

	public Account getFromAccount() {
		return fromAccount;
	}

	public AccountTranscation setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
		return this;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public AccountTranscation setToAccount(Account toAccount) {
		this.toAccount = toAccount;
		return this;
	}

	public double getAmount() {
		return amount;
	}

	public AccountTranscation setAmount(double amount) {
		this.amount = amount;
		return this;
	}
	
	/**
	 * Return the signed amount according to transaction type and from/to account
	 * @return
	 */
	public double getApplyAmount(Account acc){
		if( acc.equals(fromAccount) ){
			return -amount;
		}else if( acc.equals(toAccount)){
			return amount;
		}else{
			new RuntimeException("Cannot find a matching account");
		}
		return 0;
	}

}
