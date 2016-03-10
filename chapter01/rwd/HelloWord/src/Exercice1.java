import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helloworld.Printer;

public class Exercice1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/beans.xml");

		Printer helloEnlgish = (Printer) context.getBean("helloenlgish");
		Printer helloSpanish = (Printer) context.getBean("hellospanish");

		System.out.println(helloEnlgish.print());
		System.out.println(helloSpanish.print());

		((ClassPathXmlApplicationContext) context).close();
	}

}
