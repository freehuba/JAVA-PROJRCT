package com.jsp.mobile.components;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteMobile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DeleteMobile() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int mobileId = Integer.parseInt(req.getParameter("mobileId"));
		
		final String jdbc_Driver = "com.mysql.cj.jdbc.Driver";
		final String jdbc_Url = "jdbc:mysql://localhost:3306/tms";
		final String user_Name = "root";
		final String user_Password = "flower2V@#";
		final String dml_query= "DELETE FROM tms.mobile WHERE (mobileId = ?)";
		Connection con = null;
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		try 
		{
			Class.forName(jdbc_Driver);
			con = DriverManager.getConnection(jdbc_Url, user_Name, user_Password);
			PreparedStatement pstm = con.prepareStatement(dml_query);
			
			pstm.setInt(1, mobileId);
			
			int delete = pstm.executeUpdate();
				
			if(delete==1)
			{
				System.out.println(delete+" record deleted successfully");
				res.sendRedirect("index.jsp");
			}
			else
				System.out.println("not delete..!");
				
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println("somthing went wrong..!");
		}
		
		
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	}
