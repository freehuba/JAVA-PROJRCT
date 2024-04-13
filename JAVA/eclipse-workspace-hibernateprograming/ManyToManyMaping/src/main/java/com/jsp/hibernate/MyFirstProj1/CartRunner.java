package com.jsp.hibernate.MyFirstProj1;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CartRunner {

	public static void main(String[] args) 
	{
		Cart c1 = new Cart();
		c1.setcId(100);
		c1.setcCapacity(10);
		
		Cart c2 = new Cart();
		c2.setcId(101);
		c2.setcCapacity(20);
		
		Item i1 = new Item();
		i1.setiId(1001);
		i1.setiName("PackofSoap");
		i1.setiPrice(450);
		
		Item i2 = new Item();
		i2.setiId(1002);
		i2.setiName("PackofBiscuits");
		i2.setiPrice(500);
		
		Item i3 = new Item();
		i3.setiId(1003);
		i3.setiName("RiceBags");
		i3.setiPrice(3000);
		
		c1.setIlist(Arrays.asList(i1,i2,i3));
		c2.setIlist(Arrays.asList(i1,i2,i3));
		
//		i1.setClist(Arrays.asList(c1,c2));
//		i2.setClist(Arrays.asList(c1,c2));
//		i3.setClist(Arrays.asList(c1,c2));
		
		
		SessionFactory session = new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Item.class).buildSessionFactory();
		
		Session ss = session.openSession();
		
		Transaction tx = ss.beginTransaction();
		
		ss.save(c1);
		ss.save(c2);
		ss.save(i1);
		ss.save(i2);
		ss.save(i3);
		
		tx.commit();
		session.close();

	}

}
