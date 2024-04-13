package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet  extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String str1 = req.getParameter("first");
		String str2 = req.getParameter("second");
		
		double num1 = Double.parseDouble(str1);
		double num2 = Double.parseDouble(str2);
		
		double sum = num1+num2;
		
		PrintWriter out = res.getWriter();
		
		out.print("<h1 style=\"color: red;font-size: 50px\">Addation of two Numbers : <marquee>"+num1+" + "+num2+" = "+sum+"</marquee></h1>");
		
	}

}
