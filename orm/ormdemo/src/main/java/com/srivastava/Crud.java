package com.srivastava;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Crud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Transient State
		Employee emp = new Employee();
		emp.setName("RameshKumar");
		emp.setId(1003);
		emp.setSalary(9999);
		emp.setCity("DEL");
		emp.setDoj(new Date());
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		// Persistance State
		session.save(emp);
		emp.setSalary(888888);
		trans.commit();
		session.close();
		// Deattach
		System.out.println("Emp Object is "+emp);

	}

}
