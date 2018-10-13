package com.srivastava.apps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Producer implements IProducer {
	private String data;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void show() {
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Producer Show "+data );
	}
}
