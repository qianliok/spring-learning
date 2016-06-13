package spring.training.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import spring.training.model.Account;

@Component
public class AccountDao {

	@Autowired
	@Qualifier("springJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public Account updateAccountBalance(Account account) {
		jdbcTemplate.update(
				"update account set accountAmount = ? where accountNumber = ?",
				account.getAccountAmount(), account.getAccountNumber());
		return account;
	}


	public Object checkAccountBalance(int accountNumber) {
		String balance = jdbcTemplate.queryForObject(
				"select accountAmount from account where accountNumber = ?", 
				String.class,
				accountNumber);
		return balance;
	}

	public Account selectAccount(int accountNumber){
		String sql = "select * from account where accountNumber =  ?";
		 
		Account acc = (Account) jdbcTemplate.queryForObject(
				sql,
				new BeanPropertyRowMapper<Account>(Account.class), 
				accountNumber);
		
		return acc;
	}
}