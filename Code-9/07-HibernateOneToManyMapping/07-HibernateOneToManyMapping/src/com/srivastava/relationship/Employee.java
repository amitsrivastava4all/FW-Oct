package com.srivastava.relationship;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="emp_tab10")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private double sal;
	
	//@OneToMany
	//@OneToMany(cascade=CascadeType.ALL)
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="emp_dept_mapping",joinColumns=@JoinColumn(name="eid"),inverseJoinColumns=@JoinColumn(name="deptno"))
	// Has a relationship
	// one employee having list of depts
	Collection<Dept> dept = new ArrayList<Dept>();
	
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sal=" + sal + ", dept="
				+ dept + "]";
	}
	public Collection<Dept> getDept() {
		return dept;
	}
	public void setDept(Collection<Dept> dept) {
		this.dept = dept;
	}
	

}
