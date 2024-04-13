package com.jsp.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) 
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","flower2V@#");
			final String str = "UPDATE employeedatabase.student SET StudentAddre = ? WHERE (studentId = ?)";
			PreparedStatement pstm = con.prepareStatement(str);
			pstm.setString(1, "sagara");
			pstm.setInt(2,100);
			
			int x = pstm.executeUpdate();
			
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
