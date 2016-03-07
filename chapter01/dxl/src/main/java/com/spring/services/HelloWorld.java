package com.spring.services;


public class HelloWorld implements EchoService {

	private String message = "Hello, world!";

	/*
	 * I initially forgot this, but a bean needs a constructor with no arguments,
	 * otherwise you get a runtime exception when initialising the object.
	 */
	public HelloWorld () {
		super();
	}

	public HelloWorld (String message) {
		this();
		this.message = message;
	}

	public void setMessage (String message) {
		this.message = message;
	}

	public String echo() {
		return message;
	}

}
