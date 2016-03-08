package org.spring.bankapp.model;

import org.springframework.stereotype.Service;

@Service("HelloWorldBean")
public class HelloWorldBean {
	 
		private String greet;
	 
		public void setGreet(String greet) {
			this.greet = greet;
		}
	 
		public String getGreet(){
			return this.greet;
		}
		
}
