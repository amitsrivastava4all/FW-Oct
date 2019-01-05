package com.srivastava.relationship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="dept_mst")
public class Dept {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int deptno;
	String deptName;
	@OneToOne
	//@JoinColumn(name="id")
	Employee emp;
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
	
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "Dept1 [deptno=" + deptno + ", deptName=" + deptName; 
				//+ ", emp="
				//+ emp + "]";
	}

}
