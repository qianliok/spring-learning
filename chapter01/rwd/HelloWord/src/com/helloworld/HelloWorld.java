package com.helloworld;

public class HelloWorld implements Printer {

	private String message;

	public HelloWorld(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String print() {
		return message;
	}

}
