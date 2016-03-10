package spring.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.training.model.Name;

@Controller
public class MyFirstController {
	private String message = "Hello ";
	
	public String getMessage() {
		return message;
	}

	
	public void setMessage( String message ) {
		this.message = message;
	}

	
	public Name getName() {
		return name;
	}

	
	public void setName( Name name ) {
		this.name = name;
	}

	@Autowired
	private Name name = new Name("joe");
	 
	@RequestMapping("/hello")
	public ModelAndView showMessage() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("name", name.getName());
		return mv;
	}
}
