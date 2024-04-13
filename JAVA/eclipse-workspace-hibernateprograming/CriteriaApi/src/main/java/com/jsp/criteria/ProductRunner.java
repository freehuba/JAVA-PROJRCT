package com.jsp.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ProductRunner {

	public static void main(String[] args) 
	{
		
		Consumer c1 = new Consumer();
		c1.setConsumerId(420);
		c1.setConsumerName("Hemanth");
		c1.setConsumerContact("6361125654");
		
		
		Consumer c2 = new Consumer();
		c2.setConsumerId(421);
		c2.setConsumerName("Prashanth");
		c2.setConsumerContact("6361125654");
		
		Consumer c3 = new Consumer();
		c3.setConsumerId(422);
		c3.setConsumerName("Sumanth");
		c3.setConsumerContact("6361125654");
		
		
		Product p1 = new Product();
		p1.setProductId(1010);
		p1.setProductName("Mobile");
		p1.setProductQuntity(10);
		p1.setProductPrice(20000.0);
		p1.setConsum(c1);
		
		Product p2 = new Product();
		p2.setProductId(1011);
		p2.setProductName("Food");
		p2.setProductQuntity(10);
		p2.setProductPrice(24000.0);
		p2.setConsum(c2);
		
		Product p3 = new Product();
		p3.setProductId(1012);
		p3.setProductName("Washing Powdar");
		p3.setProductQuntity(10);
		p3.setProductPrice(90000.0);
		p3.setConsum(c3);
		
		Product p4 = new Product();
		p4.setProductId(1013);
		p4.setProductName("laptop");
		p4.setProductQuntity(10);
		p4.setProductPrice(30000.0);
		p4.setConsum(null);
		
		Product p5 = new Product();
		p5.setProductId(1014);
		p5.setProductName("Bags");
		p5.setProductQuntity(10);
		p5.setProductPrice(60000.0);
		p5.setConsum(null);
		
		
		Product p6 = new Product();
		p6.setProductId(1015);
		p6.setProductName("Shoes");
		p6.setProductQuntity(10);
		p6.setProductPrice(40000.0);
		p6.setConsum(null);
		
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Consumer.class).addAnnotatedClass(Product.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		ss.save(c1);
		ss.save(c2);
		ss.save(c3);
		ss.save(p1);
		ss.save(p2);
		ss.save(p3);
		ss.save(p4);
		ss.save(p5);
		ss.save(p6);
		
		
		tx.commit();
		sf.close();
		
		System.out.println("inserted");

	}

}
