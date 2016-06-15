package com.github.sebin.chapter03.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.github.sebin.chapter03.Account;
import com.github.sebin.chapter03.User;
import com.github.sebin.chapter03.dao.AccountDAO;

public class AccountDAOJDBC implements AccountDAO {
	private static final String SQL_FIND_ACCOUNT = "SELECT username, password, accountBalance, accountMaxBalance from Account where accountId=?";
	private static final String SQL_UPDATE_= "update Account set accountBalance=? where accountId=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void credit(Account account) {
		updateAmount(account);
	}

	public void debit(Account account) {
		updateAmount(account);
	}
	
	private void updateAmount(Account account){
		jdbcTemplate.update(SQL_UPDATE_, account.getAccountBalance());		
	}

	public Account findById(final int accountID) {
		
		return jdbcTemplate.queryForObject(SQL_FIND_ACCOUNT, new ParameterizedRowMapper<Account>() {

			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Account(accountID, 
						new User(1,
								rs.getString("username"),
								rs.getString("password"),
								"Full Name"
								),
						"accountDescription",
						rs.getDouble("accountBalance"),
						rs.getDouble("accountMaxBalance"));
			}
		});
	}

}
