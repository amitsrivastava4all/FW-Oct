package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApp {
	@RequestMapping(value="/json",method=RequestMethod.GET)
	public String getJSON() {
		return "{id:1001,name:'ram'}";
	}

}
