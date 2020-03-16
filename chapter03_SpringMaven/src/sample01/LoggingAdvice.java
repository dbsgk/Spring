package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//Aspect(공통사항 넣는 공통모듈)
@Aspect //나는 공통모듈이에요 하고 알려주는 것.
@ComponentScan("com.conf")
public class LoggingAdvice {
	
	@Before("execution(public void sample01.MessageBeanImpl.*Before(..))")
	public void beforeTrace() {
		System.out.println("before trace...");
	}
	
	@After("execution(public * *.*.*After(..))")
	public void afterTrace() {
		System.out.println("after trace...");
	}
	
	@Around("execution(public * *.*.*Print(..))")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName = joinPoint.getSignature().toShortString();
		//누가 불렀는지 간단하게 메소드 이름 찍어라.
		System.out.println("methodName= "+methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		System.out.println("호출 전= "+methodName);

		Object ob = joinPoint.proceed();//핵심 관심사항 호출(가장 중요)*** 여기서 불러옴.
		//해당 메소드가 void면 null. null이어도 작동은 함.
		System.out.println("ob= "+ob);

		sw.stop();
		System.out.println("호출 후= "+methodName);
		System.out.println("처리시간= "+sw.getTotalTimeMillis()/1000+"초");

	}
}
