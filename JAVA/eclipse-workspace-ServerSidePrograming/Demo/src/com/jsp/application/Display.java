package com.jsp.application;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Display {

	public static void main(String[] args) 
	{
		
		Connection con =null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase", "root","flower2V@#");
			final String dql_query ="SELECT * FROM employeedatabase.student";
			
			PreparedStatement pstm = con.prepareStatement(dql_query);
			ResultSet rs = pstm.executeQuery();
			
			System.out.println(rs);
			
			System.out.println("Student-Id      "+"Student-Name    "+"Student-Email                    "+"Student-Address");
			while(rs.next())
			{
				
				System.out.println(rs.getInt(1)+"             "+rs.getString(2)+"             "+rs.getString(3)+"             "+rs.getString(4));
			}
			
			
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
