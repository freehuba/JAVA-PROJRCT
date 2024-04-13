package com.jsp.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Company company = new Company();
		company.setcId(1001);
		company.setcName("Microsoft");

		Employee e1 = new Employee();
		e1.setEmpId(101);
		e1.setEmpName("hemanth");
		e1.setEmpSal(45000.0);
		e1.setCompany(company);

		Employee e2 = new Employee();
		e2.setEmpId(102);
		e2.setEmpName("sumanth");
		e2.setEmpSal(25000.0);
		e2.setCompany(company);

		Employee e3 = new Employee();
		e3.setEmpId(103);
		e3.setEmpName("prashanth");
		e3.setEmpSal(15000.0);
		e3.setCompany(company);

		// SessionFactory sf = new
		// Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();

		Configuration conf = new Configuration();
		conf.configure();
		conf.addAnnotatedClass(Employee.class);
		conf.addAnnotatedClass(Company.class);
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(company);

		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		for (Employee emp : list) {
			session.save(emp);
		}

		tx.commit();
		session.close();
		factory.close();

	}
}
