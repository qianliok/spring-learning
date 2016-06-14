package spring.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.training.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao  {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Account> getAccounts() {
		Map<String, Object> params = new HashMap<String, Object>();
		String accSql = "SELECT * FROM account";
		List<Account> result = namedParameterJdbcTemplate.query(accSql, params, new AccountMapper());

		return result;
	}
	
	private static final class AccountMapper implements RowMapper<Account> {

		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account acc = new Account(rs.getLong("number"), rs.getLong("number"), rs.getString("description"), null, null);
			acc.setAccountBalance(rs.getBigDecimal("balance"));
			return acc;
		}
	}
	
}
