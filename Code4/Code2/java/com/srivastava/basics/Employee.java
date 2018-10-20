package com.srivastava.basics;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Employee implements ApplicationContextAware {
private int id;
private String name;
//private Address address;
private ApplicationContext ac;


public Address getAddressObject() {
	if(id==1) {
		return (Address)ac.getBean("addressObject");
	}
	else
	if(id==2) {	
		return (Address) ac.getBean("addressObject2");
	}
	else
		if(id==3) {	
			return (Address) ac.getBean("addressObject3");
		}
	return null;
}

public Employee() {
	System.out.println("Employee Class Cons Call");
}
public int getId() {
	return id;
}
public void setId(int id) {
	System.out.println("Setting Id ");
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	System.out.println("Setting Name");
	this.name = name;
}
//public Address getAddress() {
//	return address;
//}
//public void setAddress(Address address) {
//	System.out.println("Employee Class Setter Called....");
//	this.address = address;
//}

 @Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Good Bye Employee..");
	}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name 
			+ "]";
}
@Override
public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	// TODO Auto-generated method stub
	System.out.println("Setter Called....");
	this.ac = applicationContext;
	
	
}

}
