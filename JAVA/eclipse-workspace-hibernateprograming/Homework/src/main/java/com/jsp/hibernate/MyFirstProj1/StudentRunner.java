package com.jsp.hibernate.MyFirstProj1;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentRunner 
{
	
	public static void main(String[] args) 
	{
		Student s = new Student();
		s.setStudent_id(101);
		s.setStudent_Name("Hemanth");
		
		Subject sub1 = new Subject();
		sub1.setSubject_id(401);
		sub1.setSubject_Name("Java");
		
		Subject sub2 = new Subject();
		sub2.setSubject_id(402);
		sub2.setSubject_Name("MySql");
		
		Subject sub3 = new Subject();
		sub3.setSubject_id(403);
		sub3.setSubject_Name("Spring");
		
		Subject sub4 = new Subject();
		sub4.setSubject_id(404);
		sub4.setSubject_Name("Hibernate");
		
		
		s.setLsub(Arrays.asList(sub1,sub2,sub3,sub4));
		
		SessionFactory session = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Subject.class).buildSessionFactory();
		
		Session ss = session.openSession();
		
		Transaction tx = ss.beginTransaction();
		
		ss.save(s);
		ss.save(sub1);
		ss.save(sub2);
		ss.save(sub3);
		ss.save(sub4);
		tx.commit();
		session.close();
	}
}
