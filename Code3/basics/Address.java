package com.srivastava.basics;

import java.util.HashSet;

public class Address {
private String city;
private String state;
private String zipCode;

@Override
public int hashCode() {
	if(city.equals("delhi")) {
		return 100;
	}
	else
	if(city.equals("mumbai")) {
		return 200;
	}
	return 300;
}

public boolean equals(Object object) {
	if(this == object) {
		return true;
	}
	if(object instanceof Address) {
		Address a = (Address)object;
		if(this.city.equals(a.city) && this.state.equals(a.state) && this.zipCode.equals(a.zipCode)) {
			return true;
		}
	}
	return false;
}


public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
@Override
public String toString() {
	return "Address [city=" + city + ", state=" + state + ", zipCode="
			+ zipCode + "]";
}
public static void main(String[] args) {
	HashSet<Address> addressSet = new HashSet<>();
	Address a = new Address();
	a.setCity("delhi");
	a.setState("delhi");
	a.setZipCode("110007");
	addressSet.add(a);
	Address a2 = new Address();
	a2.setCity("delhi");
	a2.setState("delhi");
	a2.setZipCode("110007");
	addressSet.add(a2);
	System.out.println(addressSet);
}
}
