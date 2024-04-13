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
import org.hibernate.cfg.Configuration;

@WebServlet("/fetch_employee")
public class FetchEmployee extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int employee_Id = Integer.parseInt(req.getParameter("employee_id"));
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session ss = sf.openSession();
		Object o = ss.get(Employee.class, new Integer(employee_Id));
		Employee emp = (Employee)o;
		
		PrintWriter out = res.getWriter();
		
		out.println("<table border=\"5\" cellspacing=\"0\" cellpadding=\"20\" align=\"center\" style=\"border: 2px solid blue;\">\r\n"
				+ "    <thead style=\"color: rgb(255, 0, 0); font-size: 20px; font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;\">\r\n"
				+ "        <th>Employee-Id</th>\r\n"
				+ "        <th>Employee-Name</th>\r\n"
				+ "        <th>Employee-Email</th>\r\n"
				+ "        <th>Employee-Address</th>  \r\n"
				+ "    </thead>");
		
		out.println("<tr style=\"color: brown; font-size: 15px; font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;\">\r\n"
				+ "        <td>"+emp.getEmployee_Id()+"</td>\r\n"
				+ "        <td>"+emp.getEmployee_Name()+"</td>\r\n"
				+ "        <td>"+emp.getEmployee_Email()+"</td>\r\n"
				+ "        <td>"+emp.getEmployee_Address()+"</td>\r\n"
				+ "    </tr>");
		
		out.println(" </table>");
		ss.close();
		
		
	}

}
