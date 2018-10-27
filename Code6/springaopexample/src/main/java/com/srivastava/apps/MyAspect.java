package com.srivastava.apps;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	private long startTime;
	//@Pointcut("execution(void print()) || execution(void show())")
	@Pointcut("execution(* A.*(..)) ")
	public void mypointcut() {
		
	}
	
	@Around("execution(void print()) || execution(void show())")
	public void doStuff(ProceedingJoinPoint obj) {
		long startTime = System.currentTimeMillis();
		System.out.println("Before Proceed");
		try {
			obj.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time Taken "+(endTime-startTime)+"ms");
	}

	//@Before("execution(void print()) || execution(void show())")
	@Before("MyAspect.mypointcut()")
	public void start(JoinPoint jp) {
		startTime = System.currentTimeMillis();
		//System.out.println("Before Print Call "+jp.getStaticPart().getSignature());
	}
	//@After("execution(void com.srivastava.apps.Employee.print())")
	@After("MyAspect.mypointcut()")
	public void end(JoinPoint jp) {
		System.out.println("After Print Call");
		System.out.println(jp.getStaticPart().getSignature()+"Total Time Taken "+(System.currentTimeMillis() - startTime));
	}
	
}
