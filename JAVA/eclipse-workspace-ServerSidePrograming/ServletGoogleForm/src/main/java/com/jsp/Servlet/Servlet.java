package com.jsp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String sid = req.getParameter("id");
		String sname = req.getParameter("name");
		String semail = req.getParameter("email");
		String sadd = req.getParameter("address");
		
		int stdid = Integer.parseInt(sid);
		
		PrintWriter out = res.getWriter();
	
		out.print("<h1 style=\"font-size: 50px; color: red\"><marquee>Record saved successfully...!</marquee></h1>");
		
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","flower2V@#");
			final String str = "INSERT INTO employeedatabase.student (studentId, StudentName, StudentEmail, StudentAddre) VALUES (?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(str);
			pstm.setInt(1,stdid);
			pstm.setString(2, sname);
			pstm.setString(3, semail);
			pstm.setString(4, sadd);
			
			int x = pstm.executeUpdate();
			
			System.out.println("done");
			
			
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		
		{
			e.printStackTrace();
		}
		
		finally 
		{
			if(con!=null)
			{
				try 
				{
					con.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
				
	}

}
