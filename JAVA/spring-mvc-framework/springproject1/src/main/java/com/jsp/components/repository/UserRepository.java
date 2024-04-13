package com.jsp.components.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.jsp.components.model.User;


@Repository
public class UserRepository 
{
	public static Session getSession()
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();	
		return session;
		
	}

	//save
	public void saveUser(User user)
	{
		 Session ss=UserRepository.getSession();
		 Transaction tx=ss.beginTransaction();
		 
		 ss.save(user);
		 
		 tx.commit();
		 ss.close();
		 
	}
}
