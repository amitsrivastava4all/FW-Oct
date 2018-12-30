package com.srivastava.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.srivastava.entity.Employee;

public class EmployeeDAO {
	SessionFactory sessionFactoy = new Configuration().configure().buildSessionFactory();
	
	public String add(Employee employee){
		String message = "error in record insertion";
		Session session = sessionFactoy.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		//session.saveOrUpdate(employee);
		//session.persist(employee);
		
		transaction.commit();
		session.close();
		message = "Record Saved SuccessFully";
		return message;
	}
	
	public Employee findById(int id){
		Employee employee = null;
		Session session = sessionFactoy.openSession();
		//Employee employee = new Employee();
		//employee.setId(id);
		//employee = (Employee)session.load(Employee.class, id);  // get pick 
							//session.get(Employee.class, id)
		System.out.println("Before GET ");
		employee = (Employee)session.get(Employee.class, id); 
		System.out.println("After Get");
		employee = (Employee)session.get(Employee.class, id); 
		employee = (Employee)session.get(Employee.class, id); 
		System.out.println("Query Not Run...");
		System.out.println(employee.getName());
		session.close();
		return employee;
	}
	
	public String delete(int id){
		String message = "error in record deletion";
		Employee employee = this.findById(id);
		if(employee!=null){
			Session session = sessionFactoy.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
			session.close();
			System.out.println("Record Deleted SuccessFully !");
		}
		return message;
	}
	
	public String update(int id){
		String message = "error in record updation";
		Employee employee = this.findById(id);
		if(employee!=null){
			employee.setAddress("New Address");
			Session session = sessionFactoy.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			//session.merge(employee);
			
			transaction.commit();
			session.close();
			System.out.println("Record Deleted SuccessFully !");
		}
		return message;
	}

}
