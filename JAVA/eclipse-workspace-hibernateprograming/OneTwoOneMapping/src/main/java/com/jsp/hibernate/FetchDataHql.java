package com.jsp.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchDataHql {

	public static void main(String[] args) {
		SessionFactory session = new Configuration().configure().addAnnotatedClass(Owner.class)
				.addAnnotatedClass(House.class).buildSessionFactory();
		Session ss = session.openSession();

		
		  Query<House> query = ss.createQuery("select h from House h");
		  //"from House h"
		  
		  List<House> lhouse = query.list();
		  
		  for(House h : lhouse) { System.out.println(h); }
		 
		
		/*
		Query<House> query = ss.createQuery("select h.house_Id, h.house_Loc, h.house_Rent  from House h");
		List list = query.list();

		Iterator itr = list.iterator();

		while (itr.hasNext()) 
		{
			Object[] obj = (Object[]) itr.next();
			System.out.println(obj[0] + "      " + obj[1] + "      " + obj[2]);
		}
		*/
		Transaction tx = ss.beginTransaction();
		tx.commit();
		session.close();

	}

}
