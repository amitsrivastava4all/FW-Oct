package com.srivastava.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IProducer producer = (IProducer)context.getBean("myproducer");
		producer.show();
		MyBean obj  = (MyBean)context.getBean("abcd");
		obj.print();
	}

}
