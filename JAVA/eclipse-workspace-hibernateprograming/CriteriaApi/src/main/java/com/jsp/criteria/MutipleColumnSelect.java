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

@SuppressWarnings("deprecation")
public class MutipleColumnSelect {

	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Consumer.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		CriteriaBuilder cb = ss.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Product> root = query.from(Product.class);
		
		Path<Object> pid = root.get("productId");
		Path<Object> pname = root.get("productName");
		//Path<Object> pprice = root.get("productPrice");
		//query.select(cb.array(pid,pname,pprice))
		query.multiselect(pid,pname);
		query.where(cb.ge(root.get("productPrice"), 40000));
		
		
		
		Query<Object[]> query2 = ss.createQuery(query);
		List<Object[]> list = query2.getResultList();
		for (Object[] p : list) 
		{
			System.out.println("ProductId : "+p[0]);
			System.out.println("ProductName : "+p[1]);
			//System.out.println("ProductPrice : "+p[2]);
			System.out.println();
		}
		
		
		
		tx.commit();
		ss.close();
		sf.close();
		
	}

}
