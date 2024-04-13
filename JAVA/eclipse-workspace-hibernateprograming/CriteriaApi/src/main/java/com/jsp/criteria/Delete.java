package com.jsp.criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Delete {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Consumer.class)
				.addAnnotatedClass(Product.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		CriteriaBuilder cb = ss.getCriteriaBuilder();
		
		
//		CriteriaDelete<Product> delete = cb.createCriteriaDelete(Product.class);
//		Root<Product> root = delete.from(Product.class);
//		delete.where(cb.equal(root.get("productId"), 1010));		
//		Query query = ss.createQuery(delete);
//		int i = query.executeUpdate();
//		System.out.println("Number of rows deleted :"+i);
		
		CriteriaUpdate<Product> update = cb.createCriteriaUpdate(Product.class);
		Root<Product> root = update.from(Product.class);
		update.set(root.get("productPrice"), 40000);
		update.where(cb.equal(root.get("productId"), 1013));
		Query query = ss.createQuery(update);
		int j = query.executeUpdate();
		System.out.println("Updated successfully");
		
		tx.commit();
		ss.close();
		sf.close();
		

		
	}

}
