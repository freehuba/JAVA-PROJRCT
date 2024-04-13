package com.jsp.criteria;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.google.protobuf.ExperimentalApi;

public class Aggregate {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Consumer.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		
		//aggregate function
	/*	CriteriaBuilder cb = ss.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Product> root = query.from(Product.class);
		query.multiselect(cb.count(root.get("productQuntity")),
				cb.max(root.get("productPrice")),
				cb.min(root.get("productPrice")),
				cb.sum(root.get("productPrice")),
				cb.avg(root.get("productPrice")));
		
		Query query2 = ss.createQuery(query);
		List<Object[]> resultList = query2.getResultList();
		for (Object[] objects : resultList) {
			System.out.println(Arrays.deepToString(objects));
			
		}*/
		
		CriteriaBuilder cb = ss.getCriteriaBuilder();
		CriteriaQuery<Object> query = cb.createQuery(Object.class);
		//Subquery<Product> subquery = query.subquery(Product.class);
		Root<Product> root = query.from(Product.class);
		
		query.multiselect(root.get("productName"));
		//.where(cb.in(cb.max(root.get("productId"))));
		
		
		Query<Object> query2 = ss.createQuery(query);
		List<Object> list = query2.getResultList();
		
		for (Object object : list) {
			
			System.out.println(object);
		}
		
		
		tx.commit();
		ss.close();
		sf.close();

	}

}
