package com.srivastava.basics;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	SessionFactory sessionFactoy = new Configuration().configure().buildSessionFactory();
     


	public void add(int id, String name, double salary, Date joiningDate)
	{
		Session session = sessionFactoy.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee ram = new Employee();
		ram.setId(id);
		ram.setName(name);
		ram.setSalary(salary);
		ram.setJoiningDate(joiningDate);
		
		session.save(ram);
		transaction.commit();
		session.close();
		System.out.println("Record added...");

	}
	public void delete(int id)
	{
		Session session = sessionFactoy.openSession();
		Transaction transaction = session.getTransaction();
		
		Employee emp = (Employee)session.get( Employee.class,id);
		transaction.begin();
		System.out.println("Emp Going to Delete "+emp);
		session.delete(emp);
		transaction.commit();
		session.close();
		System.out.println("Record Deleted...");
	}
	public void modify(int id)
	{
		Session session = sessionFactoy.openSession();
		Transaction transaction = session.getTransaction();
		Employee emp = (Employee)session.get( Employee.class,id);
		System.out.println("Before Modification Object is "+emp);
		transaction.begin();
		emp.setName("MIKE");
		session.merge(emp);
		transaction.commit();
		session.close();
		System.out.println("Record Modified...");
	}
	public void find()
	{
		Session session = sessionFactoy.openSession();
		Query q = session.getNamedQuery("nativequery");
		//Query query = session.getNamedQuery("selectAll");
		//query.setParameter("sal", 9000.0);
		List<Employee> empList = q.list();
		System.out.println("Result is "+empList);
		session.close();
	}

}
