package com.srivastava.apps;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.srivastava.apps"})
public class AppConfig {
	@Bean("myproducer")
	public IProducer getProducer() {
		Producer producer =  new Producer();
		try {
			producer.setData(new FS().bringData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producer;   // Complex Object
	}
}
