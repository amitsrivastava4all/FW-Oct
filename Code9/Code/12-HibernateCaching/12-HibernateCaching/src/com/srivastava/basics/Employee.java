package com.srivastava.basics;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name="Emp_cache2")
//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class Employee {
	@Id
	private int id;
	@Column(name="empname" , nullable=false)
	private String name;
	//@Transient
	private double salary;
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
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
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", joiningDate=" + joiningDate + "]";
	}
	
	
	

}
