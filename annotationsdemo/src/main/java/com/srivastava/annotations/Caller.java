package com.srivastava.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Caller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ap = new ClassPathXmlApplicationContext("spring.xml");
		MyService service = (MyService)ap.getBean("myService");
		service.service();
	}	

}
