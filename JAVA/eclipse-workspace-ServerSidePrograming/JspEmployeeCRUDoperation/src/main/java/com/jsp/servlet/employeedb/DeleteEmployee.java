package com.jsp.servlet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet

{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		int employee_Id = Integer.parseInt(req.getParameter("employee_id"));
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session  ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		Employee emp1 = new Employee();
		emp1.setEmployee_Id(employee_Id);
		
		ss.delete(emp1);
		tx.commit();
		sf.close();
		
		PrintWriter out = res.getWriter();
		out.print("<h1 style=\"font-size: 30px;color: green\" >Employee Record Deleted Successfully....!</h1>");
	
		
	}
	
}
