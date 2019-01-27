package com.srivastava.basics;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class EmployeeDAO {
	 EntityManagerFactory emf = Persistence.
			 createEntityManagerFactory("mypersistanceunit");
     


	public void add(int id, String name, double salary, Date joiningDate)
	{
		
		Employee ram = new Employee();
		ram.setId(id);
		ram.setName(name);
		ram.setSalary(salary);
		ram.setJoiningDate(joiningDate);
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		
		em.persist(ram);
		transaction.commit();
		em.close();

	}
	
	public void firstLevelCache()
	{
		System.out.println("FIRST LEVEL CACHING CODE STARTS****************************");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Employee emp1 = em.find( Employee.class,1000);
		System.out.println("EMP1 "+emp1);
		emp1.setName("eeee");
		Employee emp2 = em.find( Employee.class,1000);
		System.out.println("EMP1 "+emp2);
		
		transaction.commit();
		em.close();
		System.out.println("FIRST LEVEL CACHING CODE ENDS****************************");
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
