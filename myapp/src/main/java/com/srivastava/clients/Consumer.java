package com.srivastava.clients;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.srivastava.apps.IProducer;

public class Consumer {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("Context is Loaded....");
		IProducer producer = (IProducer)context.getBean("prod");
		//IProducer producer2 = (IProducer)context.getBean("prod");
		//System.out.println("Ref "+(producer==producer2));
		int result = producer.add(100, 200);
		System.out.println("Add is "+result);
		System.out.println("Message is "+producer.getMessage());
		
	}

}
