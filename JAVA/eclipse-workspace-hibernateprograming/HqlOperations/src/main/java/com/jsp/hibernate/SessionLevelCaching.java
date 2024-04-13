package com.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SessionLevelCaching {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		
		Session ss1 = sf.openSession();
		Transaction tx1 = ss1.beginTransaction();
		User emp1 = ss1.get(User.class, 101);
		//User emp2 = ss1.get(User.class, 101);// session level
		System.out.println(emp1);
		//System.out.println(emp2);
		tx1.commit();
		ss1.close();
		
		
		Session ss2 = sf.openSession();
		Transaction tx2 = ss2.beginTransaction();
		User emp3 = ss2.get(User.class, 101);//session factory level
		//User emp4 = ss2.get(User.class, 102);
		System.out.println(emp3);
		//System.out.println(emp4);
		tx2.commit();
		ss2.close();
		sf.close();
		
	}

}
