package com.jsp.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

public class CriteriaApi {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		Criteria criteria = ss.createCriteria(Employee.class);
		criteria.add(Restrictions.and
				(Restrictions.or
				(  
						Restrictions.ilike("employee_Name", "H%"), 
						Restrictions.ge("employee_Id", 403))
				
				,Restrictions.and
				(
						Restrictions.eq("employee_Salary", 20000.0),
						Restrictions.like("employee_Email", "%hemanthhemanthjm21797@gmail.com%") )
				));
		
		
		
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		System.out.println("-------------------");
		
		Criteria criteria1 = ss.createCriteria(Employee.class);
		criteria1.add(Restrictions.ne("employee_Name", "Hemanth"));
		
		List list2 = criteria1.list();
		
		for (Object object : list2) {
			System.out.println(object);
		}
		
		tx.commit();
		sf.close();


	}

}
