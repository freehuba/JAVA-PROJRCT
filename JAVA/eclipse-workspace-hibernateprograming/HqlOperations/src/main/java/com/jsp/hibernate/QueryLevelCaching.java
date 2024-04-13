package com.jsp.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.query.NativeQuery;

public class QueryLevelCaching {

	public static void main(String[] args) {
		SessionFactory factory = FactoryProvider.getFactory();
		Session ss = factory.openSession();
		
		Query query = ss.createQuery("select employee_Name from Employee");
		//query.setCacheable(true);
		List<String> list = query.list();
		
		for (String string : list) 
		{
			System.out.println(string);
		}
		
		System.out.println("=======================>>>>>>>>>>>>>>>>>>>>>>");
		
		Query query1 = ss.createQuery("select employee_Name from Employee");
		//query1.setCacheable(true);
		List<String> list1 = query1.list();
		
		for (String string1 : list1) 
		{
			System.out.println(string1);
		}
		
		//step 1:  add ehcache Maven dependency 2.10.9.2
		// step 2:  add hibernate-ehcache dependency version must match both hibernate==ehcache
		// step 3: add tags in pom.xml file
		// step 4: @Cachable ,@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
		// step 5: save to cache query1.setCacheable(true)
		
		
		
		ss.close();
		factory.close();

	}

}
