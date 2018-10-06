package com.brainmentors.apps;

public class Consumer {
	public static void main(String[] args) {
		IProducer prod= (IProducer)Factory.getBean();
		prod.show();
	}
}
