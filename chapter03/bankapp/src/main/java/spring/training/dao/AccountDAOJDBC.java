
package spring.training.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import spring.training.model.Account;

@Component
public class AccountDAOJDBC implements AccountDAO {

	@Autowired
	@Qualifier( "springJdbcTemplate" )
	private JdbcTemplate jdbcTemplate;

	/* @inheritdoc */
	@Override
	public Account updateAccountBalance( Account account ) {
		jdbcTemplate.update( "update account set AccountBalance = ? where AccountID = ?", account.getAccountBalance(), account.getAccountID() );
		return account;
	}

	/* @inheritdoc */
	public Object checkAccountBalance( long accountID ) {
		List<Map<String, Object>> results = jdbcTemplate.queryForList( "select * from account where accountID = ?", accountID );
		return results.get( 0 ).get( "accountBalance" ).toString();
	}

}
