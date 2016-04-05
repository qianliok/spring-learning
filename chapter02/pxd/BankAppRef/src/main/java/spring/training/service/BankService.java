package spring.training.service;

import spring.training.model.Account;
import spring.training.model.User;

public interface BankService {

	/*
	 * Debit bank service
	 */
	boolean debit(User user, Account account, double amount);

	/*
	 * Credit bank service
	 */
	boolean credit(User user, Account account, double amount);

}
