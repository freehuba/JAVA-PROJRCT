package com.jsp.hibernate;

import java.util.Arrays;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeRunner 
{
	public static void main(String[] args) 
	{
		
		Company c1 = new Company();	
		c1.setCompany_Id(1001);
		c1.setCompany_Name("MicroSoft");
		c1.setDepartment("Development");
		
		Company c2 = new Company();	
		c2.setCompany_Id(1002);
		c2.setCompany_Name("Google");
		c2.setDepartment("Testing");
		
		Company c3 = new Company();	
		c3.setCompany_Id(1003);
		c3.setCompany_Name("IBM");
		c3.setDepartment("Analystics");
		
		Employee emp1 = new Employee();		
		emp1.setEmployee_Id(401);
		emp1.setEmployee_Name("Hemanth");
		emp1.setEmployee_Salary(25000);
		emp1.setEmployee_Email("hemanth@gmail.com");
		emp1.setEmployee_Address("Shimogga");
		emp1.setCmp(c1);
		
		Employee emp2 = new Employee();
		emp2.setEmployee_Id(402);
		emp2.setEmployee_Name("Sumanth");
		emp2.setEmployee_Salary(45000);
		emp2.setEmployee_Email("sumanth@gmail.com");
		emp2.setEmployee_Address("Banglore");
		emp2.setCmp(c1);
		
		Employee emp3 = new Employee();
		emp3.setEmployee_Id(403);
		emp3.setEmployee_Name("Prashant");
		emp3.setEmployee_Salary(18000);
		emp3.setEmployee_Email("prashath@gmail.com");
		emp3.setEmployee_Address("Banglore");
		emp3.setCmp(c1);
		
		Employee emp4 = new Employee();
		emp4.setEmployee_Id(404);
		emp4.setEmployee_Name("Ankush");
		emp4.setEmployee_Salary(55000);
		emp4.setEmployee_Email("ankush@gmail.com");
		emp4.setEmployee_Address("Kundapura");
		emp4.setCmp(c1);
		
		Employee emp5 = new Employee();
		emp5.setEmployee_Id(405);
		emp5.setEmployee_Name("JeetKumar");
		emp5.setEmployee_Salary(16000);
		emp5.setEmployee_Email("jeetkumar@gmail.com");
		emp5.setEmployee_Address("Udupi");
		emp5.setCmp(c2);
		
		Employee emp6 = new Employee();
		emp6.setEmployee_Id(406);
		emp6.setEmployee_Name("Surjan");
		emp6.setEmployee_Salary(15000);
		emp6.setEmployee_Email("surjan@gmail.com");
		emp6.setEmployee_Address("Udupi");
		emp6.setCmp(c2);
		
		Employee emp7 = new Employee();
		emp7.setEmployee_Id(407);
		emp7.setEmployee_Name("Manish");
		emp7.setEmployee_Salary(25000);
		emp7.setEmployee_Email("mainsh@gmail.com");
		emp7.setEmployee_Address("Kundapura");
		emp7.setCmp(c2);
		
		Employee emp8 = new Employee();
		emp8.setEmployee_Id(408);
		emp8.setEmployee_Name("Harish");
		emp8.setEmployee_Salary(58000);
		emp8.setEmployee_Email("harish@gmail.com");
		emp8.setEmployee_Address("Shimogga");
		emp8.setCmp(c2);
		
		Employee emp9 = new Employee();
		emp9.setEmployee_Id(409);
		emp9.setEmployee_Name("Shrikanth");
		emp9.setEmployee_Salary(60000);
		emp9.setEmployee_Email("shrikanth@gmail.com");
		emp9.setEmployee_Address("Banglore");
		emp9.setCmp(c3);
		
		Employee emp10 = new Employee();
		emp10.setEmployee_Id(410);
		emp10.setEmployee_Name("Shridhar");
		emp10.setEmployee_Salary(65000);
		emp10.setEmployee_Email("shridhar@gmail.com");
		emp10.setEmployee_Address("Shimogga");
		emp10.setCmp(c3);
		
		Employee emp11 = new Employee();
		emp11.setEmployee_Id(411);
		emp11.setEmployee_Name("Ananda");
		emp11.setEmployee_Salary(70000);
		emp11.setEmployee_Email("ananda@gmail.com");
		emp11.setEmployee_Address("Banglore");
		emp11.setCmp(c3);
		
		Employee emp12 = new Employee();
		emp12.setEmployee_Id(412);
		emp12.setEmployee_Name("Anil");
		emp12.setEmployee_Salary(30000);
		emp12.setEmployee_Email("anil@gmail.com");
		emp12.setEmployee_Address("Kundapura");
		emp12.setCmp(c3);
		
		
		c1.setEmplist(Arrays.asList(emp1,emp2,emp3,emp4));
		c2.setEmplist(Arrays.asList(emp5,emp6,emp7,emp8));
		c3.setEmplist(Arrays.asList(emp9,emp10,emp11,emp12));
		
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		
		ss.save(emp1);
		ss.save(emp2);
		ss.save(emp3);
		ss.save(emp4);
		ss.save(emp5);
		ss.save(emp6);
		ss.save(emp7);
		ss.save(emp8);
		ss.save(emp9);
		ss.save(emp10);
		ss.save(emp11);
		ss.save(emp12);
		ss.save(c1);
		ss.save(c2);
		ss.save(c3);
		
		tx.commit();
		sf.close();
	}
	
	
	
}
