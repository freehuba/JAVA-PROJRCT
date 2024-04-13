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

public class Update extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String sid = req.getParameter("id");
		String sadd = req.getParameter("address");
		
		int stdid = Integer.parseInt(sid);
		
		PrintWriter out = res.getWriter();
		
		//out.print("<h1 style=\"font-size: 50px; color: green\"><marquee>Record Updated successfully...!</marquee></h1>");
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","flower2V@#");
			final String str = "UPDATE employeedatabase.student SET StudentAddre = ? WHERE (studentId = ?)";
			PreparedStatement pstm = con.prepareStatement(str);
			pstm.setString(1, sadd);
			pstm.setInt(2,stdid);
			
			int x = pstm.executeUpdate();
			
			if(x>0)
			{
				out.print("<h1 style=\"font-size: 50px; color: blue\"><marquee>Record Updated successfully...!</marquee></h1>");

			}
			else
			{
				out.print("<h1 style=\"font-size: 50px; color: blue\"><marquee>Student-Id not Found...!</marquee></h1>");

			}
			
			System.out.println("updated");
			
			
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
