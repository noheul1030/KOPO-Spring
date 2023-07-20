package kr.ac.kopo.ctc.kopo11.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class LogPointcut {

	@Pointcut("execution(* kr.ac.kopo.ctc.kopo11.board.service.*.*PointcutBefore(..))")
	private void pointcutBeforeHandler() {}
	
	@Pointcut("execution(* kr.ac.kopo.ctc.kopo11.board.service.*.*PointcutAfter(..))")
	private void pointcutAfterHandler() {}
	
	@Pointcut("execution(* kr.ac.kopo.ctc.kopo11.board.service.*.*PointcutAfterReturning(..))")
	private void pointcutAfterReturningHandler() {}
	
	@Pointcut("execution(* kr.ac.kopo.ctc.kopo11.board.service.*.*PointcutAfterThrowing(..))")
	private void pointcutAfterThrowingHandler() {}
	
	@Pointcut("execution(* kr.ac.kopo.ctc.kopo11.board.service.*.*PointcutAround(..))")
	private void pointcutAroundHandler() {}
	
	@Before("potincutBeforeHandler()")
	public void onPointcutBeforeHandler() {
		System.out.println("LogPointcut.onPointcutBeforeHandler() 핸들러 호출");
	}
	@After("potincutAfterHandler()")
	public void onPointcutAfterHandler() {
		System.out.println("LogPointcut.onPointcutAfterHandler() 핸들러 호출");
	}
	
	@AfterReturning(value="pointcutAfterReturningHandler()", returning="returnValue")
	public void onAfterReturninghandler(Object returnValue) {
		System.out.println("LogAspect.onAfterReturninghandler() 핸들러 호출");
		System.out.println("ReturnValue: " + returnValue);
	}
	@AfterThrowing(value="pointcutAfterThrowingHandler()", throwing="exception")
	public void onAfterThrowingHandler(Exception exception) {
		System.out.println("LogAspect.onAfterThrowingHandler() 핸들러 호출");
		System.out.println("Exception: " + exception.getMessage());
	}
	
	@Around("pointcutAroundHandler()")
	public void onPointcutAroundHandler(ProceedingJoinPoint pjp) {
		System.out.println("LogPointcut.onPointcutAroundHandler() 핸들러 호출, 시작점");
		try {
			pjp.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("LogPointcut.onPointcutAroundHandler() 핸들러 호출, 끝점");
	}
}
