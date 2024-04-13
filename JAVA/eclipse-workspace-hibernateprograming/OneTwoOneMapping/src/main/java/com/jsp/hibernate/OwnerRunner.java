package com.jsp.hibernate;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OwnerRunner {

	public static void main(String[] args) 
	{
		
		Owner o = new Owner();
		o.setOwner_Id(101);
		o.setOwner_Name("Hemanth");
		
		
		
		House h1 = new House();
		h1.setHouse_Id(401);
		h1.sethouse_Loc("LasVegas");
		h1.setHouse_Rent(4000);
		h1.setOwner(o);
		
		House h2 = new House();
		h2.setHouse_Id(402);
		h2.sethouse_Loc("Califonia");
		h2.setHouse_Rent(6000);
		h2.setOwner(o);
		
		House h3 = new House();
		h3.setHouse_Id(403);
		h3.sethouse_Loc("Sanfransico");
		h3.setHouse_Rent(9000);
		h3.setOwner(o);
		
		o.setLhouse(Arrays.asList(h1,h2,h3));
		
		SessionFactory session = new Configuration().configure().addAnnotatedClass(Owner.class).addAnnotatedClass(House.class).buildSessionFactory();
		
		Session ss = session.openSession();
		
		Transaction tx = ss.beginTransaction();
		
		ss.save(o);
		ss.save(h1);
		ss.save(h2);
		ss.save(h3);
		tx.commit();
		
		session.close();

	}

}
