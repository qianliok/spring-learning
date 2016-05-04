
package spring.training.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.training.exception.BankException;
import spring.training.model.Account;
import spring.training.services.AccountService;
import spring.training.services.BankService;

@Controller
public class BankController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private BankService bankService;

	public BankService getBankService() {
		return bankService;
	}

	public void setBankService( BankService bankService ) {
		this.bankService = bankService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService( AccountService accountService ) {
		this.accountService = accountService;
	}

	@RequestMapping( "/hello" )
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView( "hello" );
		return mv;
	}

	@RequestMapping( "/credit" )
	public ModelAndView creditAccount( @RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount ) {
		Account fromAccount = accountService.getAccount( from );
		Account toAccount = accountService.getAccount( to );
		ModelAndView mv = new ModelAndView( "credit" );
		try {
			bankService.debit( fromAccount, amount );
			bankService.credit( toAccount, amount );
		}
		catch ( BankException e )
		{
			mv.addObject( "error", e.getMessage() );
		}
		mv.addObject( "fromBalance", fromAccount.getAccountBalance() );
		mv.addObject( "toBalance", toAccount.getAccountBalance() );
		return mv;

	}

	@RequestMapping( "/debit" )
	public ModelAndView debitAccount( @RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount ) {
		Account fromAccount = accountService.getAccount( from );
		Account toAccount = accountService.getAccount( to );
		ModelAndView mv = new ModelAndView( "debit" );
		try {
			bankService.debit( toAccount, amount );
			bankService.credit( fromAccount, amount );
		}
		catch ( BankException e ) {
			mv.addObject( "error", e.getMessage() );
		}
		mv.addObject( "fromBalance", fromAccount.getAccountBalance() );
		mv.addObject( "toBalance", toAccount.getAccountBalance() );
		return mv;
	}
}
