package com.srivastava.basics;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
		Criteria criteria = session.createCriteria(Employee.class) ;
		// select * from employee;
		criteria.add(Restrictions.eq("name", "Ram"));
		 //select * from employee where name='Ram';
		
		criteria.add(Restrictions.between("salary", 2000, 9000));
		//// select * from employee where name='Ram' and salary >=2000 and salary<=9000;
		criteria.add(Restrictions.like("name", "R%"));
	//// select * from employee where name='Ram' and salary >=2000 and salary<=9000 and name like'R%';
		criteria.add(Restrictions.gt("salary", 9000));
		// select * from employee where name='Ram' and salary >=2000 and salary<=9000 and name like'R%' and salary>9000;
		criteria.add(Restrictions.or(Restrictions.like("name", "R%"),Restrictions.like("name", "A%")));
		//criteria.add(Restrictions.or(predicates));
		// select * from employee where name='Ram' and salary >=2000 and salary<=9000 and name like'R%' and salary>9000 and salary>777 order by name
		
		criteria.addOrder(Order.asc("name"));
		
		/*Query query = session.getNamedQuery("selectAll");
		query.setParameter("sal", 9000.0);*/
		List<Employee> empList = criteria.list();
		System.out.println("Result is "+empList);
		session.close();
	}

}
