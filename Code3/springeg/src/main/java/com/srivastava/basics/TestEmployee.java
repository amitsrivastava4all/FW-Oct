package com.srivastava.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Employee employee = (Employee)context.getBean("employeeBeanObject");
		System.out.println("Employee Details are "+employee);
		employee = null;
		System.gc();
		for(int i= 1; i<=10; i++) {
			System.out.println("I is Looping "+i);
		}
		
	}

}
