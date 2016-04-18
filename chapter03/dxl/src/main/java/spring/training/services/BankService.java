package spring.training.services;

import java.math.BigDecimal;

import spring.training.model.Account;
import spring.training.model.AccountTransaction;
import spring.training.model.TransactionResult;
import spring.training.model.TransactionStatus;

public class BankService {

	static BigDecimal minBalance = new BigDecimal(0);

	public TransactionResult debit(Account account, BigDecimal amount) {
		BigDecimal newBalance = account.getAccountBalance().subtract(amount);
		if (newBalance.compareTo(minBalance) > 0) {
			account.setAccountBalance(newBalance);
			account.addTransaction(new AccountTransaction(null, account.getAccountID(), amount.negate(), getCurrentTime()));
			return new TransactionResult(TransactionStatus.SUCCESS);
		}
		return new TransactionResult(TransactionStatus.FAILURE);
	}

	public TransactionResult credit(Account account, BigDecimal amount) {
		BigDecimal newBalance = account.getAccountBalance().add(amount);
		if (newBalance.compareTo(account.getAccountMaxBalance()) < 0) {
			account.setAccountBalance(newBalance);
			account.addTransaction(new AccountTransaction(null, account.getAccountID(), amount, getCurrentTime()));
			return new TransactionResult(TransactionStatus.SUCCESS);
		}
		return new TransactionResult(TransactionStatus.FAILURE);
	}

	public long getCurrentTime() {
		return System.currentTimeMillis();
	}
}
