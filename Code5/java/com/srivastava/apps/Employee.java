package com.srivastava.apps;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	public void print() {
		System.out.println("Employee print...");
	}
	public void show() {
		System.out.println("Employee Show");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
