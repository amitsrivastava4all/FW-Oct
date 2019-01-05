package com.srivastava.relationship;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
     


	public void add()
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee ram = new Employee();
		ram.setName("RAM");
		ram.setSal(90909);
		Employee shyam = new Employee();
		ram.setName("Shyam");
		ram.setSal(543543);
		Collection<Employee> empList = new ArrayList<Employee>();
		empList.add(ram);
		empList.add(shyam);
		Collection<Dept> deptList = new ArrayList<Dept>();
		Dept dept = new Dept();
		dept.setDeptName("IT");
		dept.setEmp(empList);
		deptList.add(dept);
		Dept dept2 = new Dept();
		dept2.setDeptName("Training");
		dept2.setEmp(empList);
		deptList.add(dept2);
		ram.setDept(deptList);
		shyam.setDept(deptList);
		
		session.save(ram);
		session.save(shyam);
		session.save(dept);
		session.save(dept2);
		
		transaction.commit();
		session.close();

	}
	public void find(int id)
	{
		Session session = sessionFactory.openSession();
		
		Employee emp = (Employee)session.get(Employee.class, id);
		if(emp!=null){
			System.out.println("Emp Object "+emp);
		}
		else
		{
			System.out.println("Not Found.......");
		}
		//transaction.commit();
		session.close();
	}
	
}
