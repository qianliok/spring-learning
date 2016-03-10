package helloworld;

import static org.junit.Assert.*;
import org.junit.Test;

import com.spring.services.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;


public class HelloWorldTest {

	@Test
	public void testHelloWorld() {
		ApplicationContext context = new ClassPathXmlApplicationContext("hello-world.xml");

		// The "standard" 'Hello, world!' message...
		EchoService helloWorld = (EchoService) context.getBean("helloWorld");
		// ...and the "dxl-version"
		EchoService helloWorldDxl = (EchoService) context.getBean("helloWorld-dxl");

		assertEquals("Default message not as expected", "Hello, world!", helloWorld.echo());
		assertEquals("Default message not as expected", "Hello, dxl!", helloWorldDxl.echo());

		// Casts may be ugly, but this avoids warnings about "resource leaks"
		// (and more importantly the leak itself)
		((ClassPathXmlApplicationContext) context).close();
	}

}
