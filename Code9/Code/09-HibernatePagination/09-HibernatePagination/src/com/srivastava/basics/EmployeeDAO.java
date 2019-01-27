package com.srivastava.basics;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	SessionFactory sessionFactoy = new Configuration().configure().buildSessionFactory();
     


	public synchronized void  add(int id, String name, double salary, Date joiningDate)
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
		System.out.println("Record Added...");

	}
	public void delete(int id)
	{
		Session session = sessionFactoy.openSession();
		
		Employee emp = (Employee)session.get( Employee.class,id);
		Transaction transaction = session.beginTransaction();
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
		Transaction transaction = session.beginTransaction();
		Employee emp = (Employee)session.get( Employee.class,id);
		System.out.println("Before Modification Object is "+emp);
		transaction.begin();
		emp.setName("MIKE");
		session.merge(emp);
		transaction.commit();
		session.close();
		System.out.println("Record Modified...");
	}
	// Using HQL
	public void find(String value)
	{
		Session session = sessionFactoy.openSession();
	/*	Transaction transaction = session.getTransaction();
		transaction.begin();*/
		Query query = session.createQuery("from Employee where salary>"
				+value);
		//Query query = session.createQuery("from Employee where salary>1000");
		List<Employee> empList = (List<Employee>)query.list();
		if(empList!=null && empList.size()>0){
			for(Employee obj : empList){
				
					System.out.println(obj);
				
			}
		}
		session.close();
		
	}
	public void getMap()
	{
		Session session = sessionFactoy.openSession();
		
			Query query = session.createQuery("select new map(name,salary) from Employee");
		
			List<Map<String,Integer>> empList = (List<Map<String,Integer>>)query.list();
			if(empList!=null && empList.size()>0){
				for(Map<String,Integer> map : empList){
					
						System.out.println(map);
					
				}
			}
			session.close();
			
	}
	@SuppressWarnings("unchecked")
	public void getNameList()
	{
		Session session = sessionFactoy.openSession();
		
		Query query = session.createQuery("select name from Employee");
	
		
		List<String> empList = (List<String>)query.list();
		//empList.get(0)
		if(empList!=null && empList.size()>0){
			for(String name : empList){
				
					System.out.println(name);
				
			}
		}
		session.close();
	}
	public void getMaxSalary()
	{
		Session session = sessionFactoy.openSession();
		
		Query query = session.createQuery("select max(salary) from Employee");
	
		List empList = (List)query.list();
		if(empList!=null && empList.size()>0){
			System.out.println("Max Salary "+empList.get(0));
		}
		session.close();
	}
	public void pagination()
	{
		Session session = sessionFactoy.openSession();
	/*	Transaction transaction = session.getTransaction();
		transaction.begin();*/
		Query query = session.createQuery("from Employee");
		query.setFirstResult(1);
		query.setMaxResults(10);
		//Query query = session.createQuery("from Employee where salary>1000");
		List<Employee> empList = (List<Employee>)query.list();
		if(empList!=null && empList.size()>0){
			for(Employee obj : empList){
				
					System.out.println(obj);
				
			}
		}
		session.close();
		
	}
	/*
	 *SQL Injection Example
	 */
	public void sqlInjection()
	{
		Session session = sessionFactoy.openSession();
			String value ="900000 or 1=1";
			Query query = session.createQuery("from Employee where salary>"+value);
			
			List<Employee> empList = (List<Employee>)query.list();
			if(empList!=null && empList.size()>0){
				for(Employee obj : empList){
					
						System.out.println(obj);
					
				}
			}
			session.close();
	}
	/*
	 * Parameter Binding prevention for SQL Injection
	 * Using Position Parameter Binding	
	 */
	public void parameterBinding()
	{
		Session session = sessionFactoy.openSession();
		
		double salary= 9000.0;
			Query query = session.createQuery("from Employee where salary>?");
			query.setDouble(0, salary);
			
			List<Employee> empList = (List<Employee>)query.list();
			if(empList!=null && empList.size()>0){
				for(Employee obj : empList){
					
						System.out.println(obj);
					
				}
			}
			session.close();
	}
	public void namedParameterBinding()
	{
		Session session = sessionFactoy.openSession();
		
		double salary= 9000.0;
			Query query = session.createQuery("from Employee where salary>:sal");
			query.setDouble("sal", salary);
			
			List<Employee> empList = (List<Employee>)query.list();
			if(empList!=null && empList.size()>0){
				for(Employee obj : empList){
					
						System.out.println(obj);
					
				}
			}
			session.close();
	}

}
