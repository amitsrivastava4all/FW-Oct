package com.srivastava.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.srivastava.domainobject.User;

public class UserDAO {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public boolean addUser(User userObject){
		boolean isAdded = false;
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try{
		session.save(userObject);
		transaction.commit();
		}
		catch(HibernateException exception){
			if(transaction!=null){
				transaction.rollback();
			}
		}
		finally{
			session.close();
			isAdded = true;
		}
		return isAdded;
	}
	

}
