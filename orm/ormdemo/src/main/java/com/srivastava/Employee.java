package com.srivastava;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name="emp_mst")
public class Employee {
	@Id
	private int id;
	@Column(name="ename",length=50,nullable=true,unique=true)
	private String name;
	private double salary;
	@Temporal(TemporalType.TIMESTAMP)
	private Date doj;
	@Type(type="yes_no")
	private boolean att;
	@Transient
	private String city;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public boolean isAtt() {
		return att;
	}
	public void setAtt(boolean att) {
		this.att = att;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", doj=" + doj + ", att=" + att
				+ ", city=" + city + "]";
	}
	
	
}
