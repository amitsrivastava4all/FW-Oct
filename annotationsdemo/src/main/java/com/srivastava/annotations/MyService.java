package com.srivastava.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MyService {
	//@Autowired
	Helper helper;
	
	public MyService() {
		System.out.println("Service Cons Call");
	}
	
	public Helper getHelper() {
		return helper;
	}

	// Setter Injection
	@Autowired
	public void setHelper(Helper helper) {
		System.out.println("Helper Setter .....");
		this.helper = helper;
	}


	public void service() {
		EmpDO empDO = helper.callDB();
		System.out.println("Emp is "+empDO);
	}
}
