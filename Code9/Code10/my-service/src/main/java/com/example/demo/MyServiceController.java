package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyServiceController {
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/services")
	public MyServiceConfiguration getConfig() {
		return new MyServiceConfiguration(configuration.getMaximum()
				, configuration.getMinimum());
	}
}
