package com.jsp.mobile.components;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		final String jdbc_Driver = "com.mysql.cj.jdbc.Driver";
		final String jdbc_Url = "jdbc:mysql://localhost:3306/tms";
		final String user_Name = "root";
		final String user_Password = "flower2V@#";
		final String dql_query= "SELECT * FROM tms.mobile";
		Connection con = null;
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		try 
		{
			Class.forName(jdbc_Driver);
			con = DriverManager.getConnection(jdbc_Url, user_Name, user_Password);
			PreparedStatement pstm = con.prepareStatement(dql_query);
			
			ResultSet rs = pstm.executeQuery();
			
			req.setAttribute("mobile", rs);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/DisplayAll.jsp");
			dispatcher.forward(req, res);
				
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println("somthing went wrong..!");
		}
		
		
		
		finally {
			try {
				
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	}

