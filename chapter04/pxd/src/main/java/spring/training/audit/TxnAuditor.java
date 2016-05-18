package spring.training.audit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class TxnAuditor {
	
	@Pointcut("execution(* spring.training.services.BankService.*(..))")
	
	
	public void auditTxn(){}
	
	@Around("auditTxn()")
	public void auditTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Auditing... " + joinPoint.getSignature().getName());
		
		System.out.println(" *** Before Transaction *** ");
		
		long begin = System.currentTimeMillis();  
		
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("Oops something went wrong!");
			e.printStackTrace();
		}
		
		System.out.println(" *** After Transaction *** ");
		
		long end = System.currentTimeMillis();
		
		System.out.println("The debit/credit txn recorded: "+( end - begin )+" ms");

	}
	
	

}
