package com.jsp.servlet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
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


@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet
{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
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
		
		Transaction  tx = ss.beginTransaction();
		ss.save(emp1);
		tx.commit();
		sf.close();
		
		//PrintWriter out = res.getWriter();
		//out.print("<h1 style=\"font-size: 30px;color: green\" >Record Successfully saved....!</h1>");
		
		//res.sendRedirect("add_display.jsp");
		
		String message = "Data inserted Successufully....";
		req.setAttribute("m", employee_Name);
		
		RequestDispatcher requestd = req.getRequestDispatcher("add_display.jsp");
		requestd.forward(req, res);
		
		
	}

	

}
