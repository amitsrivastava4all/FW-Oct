package com.srivastava.basics;

public class Employee {
private int id;
private String name;
private Address address;
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
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	System.out.println("Employee Class Setter Called....");
	this.address = address;
}

 @Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Good Bye Employee..");
	}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", address=" + address
			+ "]";
}

}
