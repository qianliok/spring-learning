package spring.training.model;

public class TransactionResult {

	TransactionStatus status;

	public TransactionStatus getStatus() {
		return status;
	}

	public TransactionResult ( TransactionStatus status) {
		this.status = status;
	}



}
