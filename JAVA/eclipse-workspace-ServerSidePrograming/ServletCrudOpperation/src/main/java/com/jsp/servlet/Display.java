package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Display extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		Connection con =null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root","flower2V@#");
			final String dql_query ="SELECT * FROM employeedatabase.student";
			
			PreparedStatement pstm = con.prepareStatement(dql_query);
			ResultSet rs = pstm.executeQuery();
			PrintWriter out = res.getWriter();
			
			out.println("<table border=\"5\" cellspacing=\"0\" cellpadding=\"20\" align=\"center\" style=\"border: 2px solid blue;\">\r\n"
					+ "    <thead style=\"color: rgb(255, 0, 0); font-size: 20px; font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;\">\r\n"
					+ "        <th>Student-Id</th>\r\n"
					+ "        <th>Student-Name</th>\r\n"
					+ "        <th>Student-Email</th>\r\n"
					+ "        <th>Student-Address</th>  \r\n"
					+ "    </thead>");
			
			
			while(rs.next())
			{
				
				out.println("<tr style=\"color: brown; font-size: 15px; font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;\">\r\n"
						+ "        <td>"+rs.getInt(1)+"</td>\r\n"
						+ "        <td>"+rs.getString(2)+"</td>\r\n"
						+ "        <td>"+rs.getString(3)+"</td>\r\n"
						+ "        <td>"+rs.getString(4)+"</td>\r\n"
						+ "    </tr>");
				
			}
			out.println(" </table>");
			
		} 
		
		catch (ClassNotFoundException | SQLException e)
		{
			
			e.printStackTrace();
		}
		
		finally 
		{
			if(con!=null)
			{
				try {  con.close();  } 
				catch (SQLException e) {  e.printStackTrace();  }
			}
		}
		
	}

	

}
