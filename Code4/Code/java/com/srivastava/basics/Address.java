package com.srivastava.basics;

public class Address {
private String city;
private String state;
private String zipCode;
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

}
