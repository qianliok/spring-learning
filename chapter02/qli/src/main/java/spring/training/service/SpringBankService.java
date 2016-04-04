package spring.training.service;

import spring.training.model.Account;
import spring.training.model.AccountTranscation;
import spring.training.model.User;

public class SpringBankService implements BankService {

	@Override
	public boolean debit(User loggedInUser, Account fromAccount,
			Account toAccount, double amount) {
		return applyTransaction(loggedInUser, fromAccount, toAccount, amount);
	}

	@Override
	public boolean debit(User loggedInUser, Account fromAccount, double amount) {
		return debit(loggedInUser, fromAccount, null, amount);
	}

	@Override
	public boolean credit(User loggedInUser, Account toAccount,
			Account fromAccount, double amount) {
		return applyTransaction(loggedInUser, fromAccount, toAccount, amount);
	}

	@Override
	public boolean credit(User loggedInUser, Account toAccount, double amount) {
		return credit(loggedInUser, toAccount, null, amount);
	}

	private boolean applyTransaction(User loggedInUser, Account outAccount,
			Account inAccount, double amount) {
		if (loggedInUser == null) {
			throw new RuntimeException("Un-authorised user");
		}

		if (amount <= 0) {
			throw new RuntimeException("Invalid transaction amount");
		}

		AccountTranscation txn = new AccountTranscation()
				.setFromAccount(outAccount).setToAccount(inAccount)
				.setAmount(amount);

		
		if( outAccount==null && inAccount==null ){
			return false;
		}
		
		
		boolean success = true;
		
		if( outAccount != null && inAccount != null ){
			if( outAccount.validateTransaction(txn.getApplyAmount(outAccount))  
					&& inAccount.validateTransaction( txn.getApplyAmount(inAccount) ) ) {
				success = outAccount.recordTransactions(txn) && inAccount.recordTransactions(txn);
				return success;
			}else{
				return false;
			}
		}else if( inAccount != null ){
			success = success && inAccount.recordTransactions(txn);
		}else if( outAccount != null ){
			success = success && outAccount.recordTransactions(txn);
		}
		
		return success;
				
	}

}
