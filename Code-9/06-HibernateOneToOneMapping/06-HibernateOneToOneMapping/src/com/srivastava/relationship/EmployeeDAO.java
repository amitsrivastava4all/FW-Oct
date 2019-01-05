package com.srivastava.relationship;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		Dept dept = new Dept();
		dept.setDeptName("IT");
		dept.setEmp(ram);
		
		ram.setDept(dept);
		session.save(ram);
		session.save(dept);
		transaction.commit();
		session.close();

	}
	public void find(int id)
	{
		Session session = sessionFactory.openSession();
		//transaction.begin();
		//Employee emp = em.find( Employee.class,id);
		
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
