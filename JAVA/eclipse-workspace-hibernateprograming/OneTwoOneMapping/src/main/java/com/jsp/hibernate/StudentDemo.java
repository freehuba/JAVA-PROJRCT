package com.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDemo {

	public static void main(String[] args) 
	{
		
		Student s1 = new Student();
		s1.setsId(101);
		s1.setsName("Hemanth");
		s1.setsContact(9902192726l);
		s1.setsPercentile(98.5);
		
		Student s2 = new Student();
		s2.setsId(102);
		s2.setsName("Sumanth");
		s2.setsContact(9967192726l);
		s2.setsPercentile(90.5);
		
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		
		Transaction tx =  ss.beginTransaction();
		
		ss.save(s1);
		ss.save(s2);
		
		tx.commit();
		
		ss.close();
		sf.close();

	}

}
