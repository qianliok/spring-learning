package org.spring.bankapp.controller;

import org.spring.bankapp.model.HelloWorldBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@SuppressWarnings("resource")
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

		// loading the definitions from the given XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloWorldBean helloWorld = (HelloWorldBean) context.getBean("HelloWorldBean");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", helloWorld.getGreet());
		mv.addObject("name", name);
		return mv;
	}
	
	
}
