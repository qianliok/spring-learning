package com.spring.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.services.EchoService;

public class Main {

	public static void main(String[] args) {

		// Load configuration
		ApplicationContext context = new ClassPathXmlApplicationContext("hello-world.xml");

		// instantiate beans
		EchoService helloWorld = (EchoService) context.getBean("helloWorld");
		EchoService helloWorldDxl = (EchoService) context.getBean("helloWorld-dxl");

		// Print some output
		System.out.println(helloWorld.echo());
		System.out.println(helloWorldDxl.echo());

		// Release memory
		((ClassPathXmlApplicationContext) context).close();
	}

}
