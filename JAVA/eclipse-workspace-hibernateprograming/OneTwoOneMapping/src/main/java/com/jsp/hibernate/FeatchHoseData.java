package com.jsp.hibernate;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FeatchHoseData {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(House.class).addAnnotatedClass(Owner.class).buildSessionFactory();
		
		Session ss = sf.openSession();
		
		Transaction tx = ss.beginTransaction();
		
		House hs = ss.get(House.class, new Integer(401));
		System.out.println(hs);
		
		House hs1 = ss.load(House.class, new Integer(401));
		System.out.println(hs1);	
	
		
		
		sf.close();

	}

}
