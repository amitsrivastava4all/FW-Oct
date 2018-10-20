package com.srivastava.basics;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Employee implements ApplicationContextAware,BeanNameAware {
private int id;
private String name;
private Address address;
private ApplicationContext appContext;
public Employee(){
	System.out.println("I am Emp Class Default Cons");
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", address=" + address
			+ "]";
}
@Override
public void setApplicationContext(ApplicationContext arg0)
		throws BeansException {
	this.appContext = appContext;
	
}
@Override
public void setBeanName(String arg0) {
	// TODO Auto-generated method stub
	
}


}
