package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String login() {
		System.out.println("Welcome ....");
		return "welcome";
	}
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String load() {
		System.out.println("Load Login...");
		return "login";
	}
	
}
