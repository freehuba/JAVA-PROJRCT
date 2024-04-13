package com.jsp.criteria;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class CriteriaApi {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Consumer.class)
				.addAnnotatedClass(Product.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		CriteriaBuilder cb = ss.getCriteriaBuilder();
		CriteriaQuery<Product> query = cb.createQuery(Product.class);
		Root<Product> root = query.from(Product.class);
		query.select(root);
		//query.where(cb.equal(root.get("productId"),1010));
		//query.where(cb.gt(root.get("productId"), 1013));
		//query.where(cb.lessThan(root.get("productPrice"), 41000));
		//query.where(cb.lt(root.get("productPrice"), 40000.0));
	
		
		
		Query<Product> query2 = ss.createQuery(query);
		List<Product> list = query2.getResultList();
		
		for (Product product : list) {
			System.out.println(product);
		}
		
		ss.close();
		sf.close();
	}
}
