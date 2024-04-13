package com.jsp.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Pagination {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) 
	{
		SessionFactory factory = FactoryProvider.getFactory();
		Session ss = factory.openSession();
		
		Query<Integer> query = ss.createQuery("select employee_Id from Employee");
		//query.setCacheable(true);
		query.setFirstResult(0);
		query.setMaxResults(60);
		List<Integer> list = query.list();
		
		for (Integer string : list) 
		{
			System.out.println(string);
		}
		
		ss.close();
		factory.close();
	}

}
