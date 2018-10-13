package com.srivastava.apps;

import org.springframework.stereotype.Component;

@Component("abcd")
public class MyBean {
	public void print() {
		System.out.println("I am a Print...");
	}
}
