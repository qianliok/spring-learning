package spring.training.service;

import spring.training.model.Account;
import spring.training.model.User;

public interface BankService {
	public boolean debit(User loggedInUser, Account fromAccount,
			Account toAccount, double amount);

	public boolean debit(User loggedInUser, Account fromAccount, double amount);

	public boolean credit(User loggedInUser, Account toAccount,
			Account fromAccount, double amount);

	public boolean credit(User loggedInUser, Account toAccount, double amount);
}
