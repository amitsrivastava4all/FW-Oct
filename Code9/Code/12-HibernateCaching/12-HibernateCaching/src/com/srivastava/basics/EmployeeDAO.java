package com.srivastava.basics;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmployeeDAO {
	EntityManagerFactory emf  = null;
	 /*EntityManagerFactory emf = Persistence.
			 createEntityManagerFactory("mypersistanceunit");*/
     SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


	public void add(int id, String name, double salary, Date joiningDate)
	{
		
		Employee ram = new Employee();
		ram.setId(id);
		ram.setName(name);
		ram.setSalary(salary);
		ram.setJoiningDate(joiningDate);
		Session session = sessionFactory.openSession();
		//EntityManager em = emf.createEntityManager();
		//EntityTransaction transaction = em.getTransaction();
		Transaction transaction = session.beginTransaction();
		//transaction.begin();
		session.save(ram);
		transaction.commit();
		session.close();

	}
	
	public void firstLevelCache()
	{
		System.out.println("FIRST LEVEL CACHING CODE STARTS****************************");
		
		Session session = sessionFactory.openSession();
		
		
		
		Employee emp1 = (Employee)session.get( Employee.class,1000); // this will execute the query
		System.out.println("EMP1 "+emp1);
		//emp1.setName("eeee");
		// 1st Level Cache
		Employee emp2 = (Employee)session.get( Employee.class,1000);  // this will pick from first level cache
		System.out.println("EMP1 "+emp2);
		
		
		session.close();  // first levle Cache Clear
		System.out.println("New Session Open");
		session = sessionFactory.openSession();
		emp2 = (Employee)session.get( Employee.class,1000);  // again execute the query
		System.out.println("EMP1 "+emp2);
		
		
		session.close();
		
		System.out.println("FIRST LEVEL CACHING CODE ENDS****************************");
	}
	
	public void secondLevelCacheUsingHibernate()
	{
		System.out.println("Second LEVEL CACHING CODE STARTS****************************");
		
		Session session = sessionFactory.openSession();
		//EntityManager em = emf.createEntityManager();
		
		
		
		Employee emp1 = (Employee)session.get( Employee.class,1000);
		System.out.println("First Time EMP1 "+emp1);
		Employee emp2 = (Employee)session.get( Employee.class,1000);
		System.out.println("First Time EMP2 "+emp2);
		
		session.close();
		//emp1.setName("eeee");
		System.out.println("Again Open Session");
		session = sessionFactory.openSession();
		Employee emp3 = (Employee)session.get( Employee.class,1000);
		System.out.println("Second Time EMP3 "+emp3);
		
		
		session.close();
		System.out.println("Second LEVEL CACHING CODE ENDS****************************");
	}

	public void secondLevelCache()
	{
		System.out.println("SECOND LEVEL CACHING CODE STARTS****************************");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Employee emp1 = em.find( Employee.class,1000);
		System.out.println("EMP1 "+emp1);
		/*Employee emp2 = em.find( Employee.class,1000);
		System.out.println("EMP1 "+emp2);
		emp1.setName("eeee");*/
		transaction.commit();
		em.close();
		
	
		em = emf.createEntityManager();
		
		 transaction = em.getTransaction();
		transaction.begin();
		Employee emp3 = em.find( Employee.class,1000);
		System.out.println("EMP3 "+emp3);
		transaction.commit();
		em.close();
		System.out.println("SECOND LEVEL CACHING CODE ENDS****************************");
	}
	public void secondLevelQueryCache(){
		System.out.println("SECOND LEVEL QUERY CACHING CODE STARTS****************************");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.name=?1",Employee.class);
		query.setHint("org.hibernate.cacheable", true);
		query.setParameter(1, "Tim");
		List<Employee> empList = query.getResultList();
		System.out.println("Emp List "+empList);
		em.close();
		System.out.println("Again doing the Same Query");
		em = emf.createEntityManager();
		query = em.createQuery("select e from Employee e where e.name=?1",Employee.class);
		query.setHint("org.hibernate.cacheable", true);
		query.setParameter(1, "Tim");
		empList = query.getResultList();
		System.out.println("Emp List "+empList);
		em.close();
		System.out.println("SECOND LEVEL QUERY CACHING CODE ENDS****************************");
	}
}
