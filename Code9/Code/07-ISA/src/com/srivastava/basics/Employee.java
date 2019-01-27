package com.srivastava.basics;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="emp_data")
@DiscriminatorValue(value="emp")
public class Employee extends Person {
private double salary;
private String designation;
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
@Override
public String toString() {
	return "Employee [salary=" + salary + ", designation=" + designation + "]";
}

}
