package com.jsp.criteria;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class CriteriaQuery1 {

	public static void main(String[] args) 
	{
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Consumer.class).buildSessionFactory();
		Session ss = factory.openSession();
		
		@SuppressWarnings("deprecation")
		Criteria crt = ss.createCriteria(Product.class);
		crt.add(Restrictions.eq("productId", 1015));
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("productName"));
		//pl.add(Projections.max("productId"));
			
		crt.setProjection(pl);
		
		List<Object> Name = crt.list();
		
		for (Object string : Name) {
			System.out.println(string);
		}
		
		ss.close();
		factory.close();

	}

}
