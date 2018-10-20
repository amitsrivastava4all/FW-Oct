package com.srivastava.basics;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {

	public static void main(String[] args) throws InterruptedException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//context.registerShutdownHook();
		Employee employee = (Employee)context.getBean("employeeBeanObject");
		employee=null;
		context.close();
		System.gc();
		for(int i = 1; i<=5 ;i++){
			System.out.println("I is "+i);
			Thread.sleep(1000);
		}
		
		//System.out.println("Employee Details are "+employee);
	}

}
