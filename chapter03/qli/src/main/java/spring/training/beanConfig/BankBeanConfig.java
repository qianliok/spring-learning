package spring.training.beanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.training.model.Account;
import spring.training.model.Customer;
import spring.training.model.User;

@Configuration
public class BankBeanConfig {

	@Bean
	public User testuser() {
		return new User().setUsername("testuser")
				.setPassword("testuser");
	}

	@Bean
	public Customer qli() {
		return new Customer().setCustomerID("12345678")
					.setName("Qian Li")
					.setUser(testuser());
	}

	@Bean
	public Account acc00000001() {
		Customer customer = qli();
		Account acc = new Account().setAccountNumber(00000001)
					.setAccountDescription("test account 1")
					.setAccountAmount(1000)
					.setCustomer(customer);
		customer.addAcount(acc);
		return acc;
	}

	@Bean
	public Account acc00000002() {
		Customer customer = qli();
		Account acc = new Account().setAccountNumber(00000002)
					.setAccountDescription("test account 2")
					.setAccountAmount(100)
					.setCustomer(customer);
		customer.addAcount(acc);
		return acc;
	}

}
