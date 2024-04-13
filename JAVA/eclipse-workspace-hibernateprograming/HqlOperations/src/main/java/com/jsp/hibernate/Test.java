package com.jsp.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) 
	{
		SessionFactory factory = FactoryProvider.getFactory();
		Session ss = factory.openSession();
		
		
		Query query = ss.createSQLQuery("select employee_name,employee_id from hql_employeedb.employee where employee_id = (select max(employee_id) from hql_employeedb.employee);");
		List list = query.list();
		
		Iterator itr = list.iterator();
		
		while(itr.hasNext())
		{
			Object[] name = (Object[]) itr.next();
			System.out.println("Employee name :" +name[0]);
			System.out.println("Employee Id :" +name[1]);
		}
		
		ss.close();
		FactoryProvider.closeFactory();

	}

}
