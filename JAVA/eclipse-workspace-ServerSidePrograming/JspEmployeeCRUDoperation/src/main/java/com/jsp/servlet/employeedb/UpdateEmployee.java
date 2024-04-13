package com.jsp.servlet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/update_employee")
public class UpdateEmployee  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int employee_Id = Integer.parseInt(req.getParameter("employee_id"));
		String employee_Name = req.getParameter("employee_name");
		String employee_Email = req.getParameter("employee_email");
		String employee_Address = req.getParameter("employee_address");
		
		Employee emp1 = new Employee();
		emp1.setEmployee_Id(employee_Id);
		emp1.setEmployee_Name(employee_Name);
		emp1.setEmployee_Email(employee_Email);
		emp1.setEmployee_Address(employee_Address);
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session  ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		ss.update(emp1);
		tx.commit();
		sf.close();
		
		PrintWriter out = res.getWriter();
		out.print("<h1 style=\"font-size: 30px;color: green\" >Employee Record Updated Successfully....!</h1>");
	
		
	}

	

}
