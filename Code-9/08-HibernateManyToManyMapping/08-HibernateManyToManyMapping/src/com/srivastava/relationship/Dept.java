package com.srivastava.relationship;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="dept_masters")
public class Dept {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int deptno;
	String deptName;
	@ManyToMany(mappedBy="dept")
	//@ManyToMany
	Collection<Employee> emp = new ArrayList<Employee>();
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", deptName=" + deptName + "]";
	}
	public Collection<Employee> getEmp() {
		return emp;
	}
	public void setEmp(Collection<Employee> emp) {
		this.emp = emp;
	}
	


}
