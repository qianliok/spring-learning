package spring.training.configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.training.model.Account;
import spring.training.model.Name;
import spring.training.model.User;
import spring.training.services.BankService;

@Configuration
public class TestConfiguration {

	@Bean
	public Name name() {
		return new Name("jock");
	}

	@Bean
	public BankService bankService() {
		return new BankService();
	}

	@Bean
	public Account accountDxl() {
		return new Account(1, 1, "dxl", accBalance(50), accMaxBalance(100));
	}

	@Bean
	public BigDecimal accBalance(double num) {
		return new BigDecimal(num);
	}

	@Bean
	public BigDecimal accMaxBalance(double num) {
		return new BigDecimal(num);
	}

	@Bean
	public User userDxl() {
		return new User("dxl", new Long(1), "boh", "daniele labartino", accountListDxl());
	}

	@Bean
	public List<Account> accountListDxl() {
		List<Account> accountList = new ArrayList<>();
		accountList.add(accountDxl());
		return accountList;
	}






}
