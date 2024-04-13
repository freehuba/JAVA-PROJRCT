package com.jsp.servlet;

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

public class Delete extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String sid = req.getParameter("id");
		
		int stdid = Integer.parseInt(sid);
		
		PrintWriter out = res.getWriter();
		
		//out.print("<h1 style=\"font-size: 50px; color: Red\"><marquee>Record Deleted successfully...!</marquee></h1>");
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","flower2V@#");
			final String str = "DELETE FROM  employeedatabase.student WHERE (studentId = ?);\r\n"
					+ "";
			PreparedStatement pstm = con.prepareStatement(str);
			pstm.setInt(1,stdid);
			
			int x = pstm.executeUpdate();
			
			if(x>0)
			{
				out.print("<h1 style=\"font-size: 50px; color: red\"><marquee>Record Deleted successfully...!</marquee></h1>");

			}
			else
			{
				out.print("<h1 style=\"font-size: 50px; color: red\"><marquee>Record not Found...!</marquee></h1>");

			}
			
			System.out.println("deleted");
			
			
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
