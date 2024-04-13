package com.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;


public class UserRunner 
{

	public static void main(String[] args) 
	{
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		String query = " SELECT userFName FROM hql_employeedb.user where userId = ( select max(userId) from hql_employeedb.user); ";
		NativeQuery<?> nativeQuery = ss.createNativeQuery(query);
		
		Object obj = nativeQuery.list();
		
		System.out.println(obj);
		
		tx.commit();
		sf.close();

	}

}
