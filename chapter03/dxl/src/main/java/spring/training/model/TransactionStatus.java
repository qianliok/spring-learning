package spring.training.model;

public enum TransactionStatus {
	SUCCESS(1),
	FAILURE(2);

	private int value;

	private TransactionStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
