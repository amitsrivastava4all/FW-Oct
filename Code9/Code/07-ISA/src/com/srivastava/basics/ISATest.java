package com.srivastava.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ISATest {

	public static void main(String[] args) {
		Person person = new Person();
		person.setName("Ram");
		Employee employee = new Employee();
		employee.setSalary(9090);
		employee.setDesignation("SE");
		Student student = new Student();
		student.setCollegeName("IIT");
		student.setCourse("M-TECH");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		session.save(employee);
		session.save(student);
		transaction.commit();
		session.close();
		System.out.println("Record Saved...");
		

	}

}
