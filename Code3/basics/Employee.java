package com.srivastava.basics;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
private int id;
private String name;
private List<Address> address;
private Map<String,Address> addressMap;
private Set<Address> addressSet;
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

public List<Address> getAddress() {
	return address;
}
public void setAddress(List<Address> address) {
	this.address = address;
}
public Map<String, Address> getAddressMap() {
	return addressMap;
}
public void setAddressMap(Map<String, Address> addressMap) {
	this.addressMap = addressMap;
}
public Set<Address> getAddressSet() {
	return addressSet;
}
public void setAddressSet(Set<Address> addressSet) {
	this.addressSet = addressSet;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", address=" + address
			+ ", addressMap=" + addressMap + ", addressSet=" + addressSet + "]";
}



}
