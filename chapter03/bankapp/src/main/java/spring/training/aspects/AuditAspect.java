
package spring.training.aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

	final static Logger logger = Logger.getLogger( AuditAspect.class );

	@Pointcut( "execution(* spring.training.services.BankService.*(..))" )
	public void audit() {
	}

	@Before( "audit()" )
	public void before_advice() {
		logger.info( "before execution" );
	}
	
	@Around( "audit()" )
	public Object audit( ProceedingJoinPoint joinpoint ) throws Throwable {
		logger.info( "Before "+joinpoint.getSignature()+" "+Arrays.toString( joinpoint.getArgs()) );
		
		Object returnVal = joinpoint.proceed();
		
		logger.info( "After "+joinpoint.getSignature()+" "+Arrays.toString( joinpoint.getArgs()) );
		return returnVal;
	}
}
