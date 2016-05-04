package com.github.sebin.chapter03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;;

@Aspect
public class Audit {
	
	@Autowired
    private ApplicationContext context;

	
	public Audit(){
	}
	
	@Pointcut("execution(* com.github.sebin.chapter03.service.BankService.credit(..)) ||"
			+ " execution(* com.github.sebin.chapter03.service.BankService.debit(..))")
	public void auditing() {
	}


	@Around("auditing()")
	public void auditBank(ProceedingJoinPoint joinpoint) {
		Counter counter = (Counter)context.getBean("auditCounter");
		try {
			long start = System.nanoTime();
			joinpoint.proceed();
			long end = System.nanoTime();
			System.out.println("credit in " + (end - start) + " nano seconds.");
			counter.increment();
		} catch (Throwable t) {
			System.out.println("Problem!");
		}
	}

}
