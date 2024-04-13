package com.jsp.components;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SubstractNumber extends GenericServlet {
	private static final long serialVersionUID = 1L;

    public SubstractNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int num3 = num1-num2;
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.print("<h1>Total :"+ num3+" </h1>");
		out.close();
	}

}
