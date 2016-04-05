package spring.training.service;

import spring.training.model.Account;
import spring.training.model.User;

public class PxdBankService implements BankService {

	@Override
	public boolean debit(User user, Account account, double amount) {

		return processTxn(user, account, amount, "debit");
	}

	@Override
	public boolean credit(User user, Account account, double amount) {

		return processTxn(user, account, amount, "credit");
	}

	private boolean processTxn(User user, Account account, double amount, String type) {
		// TODO: User auth logic
		if (type.equals("credit")) {
			if ((account.getAccountBalance() + amount) < Account.accountMaxBalance) {
				account.setAccountBalance(account.getAccountBalance() + amount);
				return true;
			} else {
				throw new RuntimeException(
						"The credited amount exceeds the maximum balance limits. Rejecting Transaction! ");
			}
		} else if (type.equals("debit")) {
			if ((account.getAccountBalance() - amount) >= 0) {
				account.setAccountBalance(account.getAccountBalance() - amount);
				return true;
			} else {
				throw new RuntimeException("There isn't enough amount in the account!");
			}
		}

		return false;
	}

}
