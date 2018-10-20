package com.srivastava.basics;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean,DisposableBean {
private int id;
private String name;
//private Address address;
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
//public Address getAddress() {
//	return address;
//}
//public void setAddress(Address address) {
//	this.address = address;
//}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name 
			//+ ", address=" + address
			+ "]";
}
@Override
public void afterPropertiesSet() throws Exception {
	System.out.println("Bean Init Method calls");
	
}
@Override
public void destroy() throws Exception {
	System.out.println("Bean Destroy CALL");
	
}
public void mydestroy(){
	System.out.println("Destroy Call");
}
public void myInit(){
	System.out.println("My Init Called");
	
}
public void myCleanUp(){
	System.out.println("My Cleanup Called");
}
@PostConstruct
public void myInit2(){
	
}
@PreDestroy
public void myCleanUp2(){
	
}
}
