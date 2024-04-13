package com.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonRunner 
{
	public static void main(String[] args) 
	{
		
		/*Pan pan = new Pan();
		pan.setPanId(2001);
		pan.setPanName("Deo");
		pan.setPanLoction("Banglore");
		
		Pan pan1 = new Pan();
		pan1.setPanId(2002);
		pan1.setPanName("Snith");
		pan1.setPanLoction("Manglore");*/
		
		
		Passport pass = new Passport();
		pass.setPassId(2023001);
		pass.setPassName("Ordinary Passport");
		
		Passport pass1 = new Passport();
		pass1.setPassId(2023002);
		pass1.setPassName("Internationl Passport");
		
		Passport pass2 = new Passport();
		pass2.setPassId(2023003);
		pass2.setPassName("Domarstic Passport");
		
		Person p1 = new Person();
		p1.setpId(100);
		p1.setpName("Hemanth");
		p1.setpContact(6361196611l);
		p1.setPass(pass);
		
		Person p2 = new Person();
		p2.setpId(101);
		p2.setpName("Prashant");
		p2.setpContact(6361196231l);
		p2.setPass(pass1);
		
		Person p3 = new Person();
		p3.setpId(103);
		p3.setpName("Ankush");
		p3.setpContact(6361177611l);
		p3.setPass(pass2);
		
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class).buildSessionFactory();
		
		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		
		ss.save(pass);
		ss.save(pass1);
		ss.save(pass2);
		
		ss.save(p1);
		ss.save(p2);
		ss.save(p3);
		
		tx.commit();
		
		factory.close();
		
		
		
	}

}
