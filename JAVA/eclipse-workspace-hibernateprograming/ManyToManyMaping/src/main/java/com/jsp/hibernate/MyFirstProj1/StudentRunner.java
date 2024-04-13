package com.jsp.hibernate.MyFirstProj1;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentRunner {

	public static void main(String[] args) 
	{
		Student s1 = new Student();
		s1.setStudent_Id(100);
		s1.setStudent_Name("Hemanth");
		
		Student s2 = new Student();
		s2.setStudent_Id(101);
		s2.setStudent_Name("Sumanth");
		
		Course c1 = new Course();
		c1.setCourse_Id(4990);
		c1.setCourse_Name("Java");
		
		Course c2 = new Course();
		c2.setCourse_Id(4991);
		c2.setCourse_Name("Hibernate");
		
		Course c3 = new Course();
		c3.setCourse_Id(4992);
		c3.setCourse_Name("MySQL");
		
		s1.setClist(Arrays.asList(c1,c2,c3));
		s2.setClist(Arrays.asList(c1,c2,c3));
		
		//c1.setSlist(Arrays.asList(s1,s2));
		//c2.setSlist(Arrays.asList(s1,s2));
		
		SessionFactory session = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session ss = session.openSession();
		
		Transaction tx = ss.beginTransaction();
		
		ss.save(s1);
		ss.save(s2);
		ss.save(c1);
		ss.save(c2);
		ss.save(c3);
		
		tx.commit();
		session.close();

	}

}
