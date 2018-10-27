package com.srivastava.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Caller {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		MyDAO dao = (MyDAO)ac.getBean("myDAO");
		dao.add("tim", "1111");
		System.out.println(dao.getAll());
		System.out.println("****************************");
		System.out.println(dao.getOne());
	}

}
