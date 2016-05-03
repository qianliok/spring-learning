package spring.training.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AuditAspect {

	@Pointcut("execution(* spring.training.service.SpringBankService.debit(..)) ||"
			+ " execution(* spring.training.service.SpringBankService.credit(..)) ")
	public void audit(){
		
	}
	
	@Before("audit()")
	public void beforeAudit(){
		System.out.println("Before the audit method");
	}
	
	@Around("audit()")
	  public void auditTimer(ProceedingJoinPoint joinpoint) throws Throwable {

	      System.out.println("["+joinpoint.toString()+"] is about to run");

	      long start = System.currentTimeMillis();
	      joinpoint.proceed();
	      long end = System.currentTimeMillis();


	      System.out.println("The debit/credit took " + (end - start)
	          + " milliseconds.");

	  }
	
	@AfterReturning("audit()")
	public void afterAudit(){
		System.out.println("After the audit method");
	}

}
