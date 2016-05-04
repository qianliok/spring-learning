package spring.training.exception;


public class BankException extends Exception {

	public BankException(String message) {
		super(message);
	}
	
	public BankException(String message, Throwable e) {
		super(message, e);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2394833893153067210L;

}
