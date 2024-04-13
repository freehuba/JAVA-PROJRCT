package com.jsp.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OredrBuQuery 
{
	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Consumer.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		CriteriaBuilder cb = ss.getCriteriaBuilder();
		CriteriaQuery<Product> query = cb.createQuery(Product.class);
		Root<Product> root = query.from(Product.class);
		query.select(root);
		//query.orderBy(cb.asc(root.get("productId")));
		query.orderBy(cb.desc(root.get("productPrice")));
		
		//query.multiselect(root.get("productId"),cb.count(root)).groupBy(root.get("productId"));
				
		Query<Product> query2 = ss.createQuery(query);
		List<Product> list = query2.getResultList();
		for (Product p : list) 
		{
			System.out.println(p);
		}
		
		
		
		tx.commit();
		ss.close();
		sf.close();
	}
}
