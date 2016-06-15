package com.github.sebin.chapter03;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sebin.chapter03.dao.AccountDAO;
import com.github.sebin.chapter03.dao.impl.AccountDAOJDBC;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:context.xml" })
public class AccountDAOJDBCTest {


	@Autowired
    private ApplicationContext context;

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	@Before
	public void setUp() {
		JdbcTemplate jt = new JdbcTemplate((DataSource) context.getBean("dataSource"));
		jt.execute("Create table Account(	"
				+ "accountId bigint,"
				+ "	username verchar(100),"
				+ "	password verchar(100),"
				+ "	accountBalance decimal(10,2),"
				+ "	accountMaxBalance decimal(10,2)"
				+ ");");
		jt.update("INSERT INTO Account (accountId, username, ,password, accountBalance, accountMaxBalance) VALUES(1,\"ABCDEF\",\"1234\",100,10000.00)");
		jt.update("INSERT INTO Account (accountId, username, ,password, accountBalance, accountMaxBalance) VALUES(2,\"XYZ\",\"1234\",100,10000.00)");

	}

	@Test
	public void canDebitAccout() {
		AccountDAO dao = new AccountDAOJDBC();
		Account account = dao.findById(1);
		account.setAccountBalance(account.getAccountBalance()-100);
		dao.debit(account);
		Assert.assertEquals(account,dao.findById(1));
	}

}
