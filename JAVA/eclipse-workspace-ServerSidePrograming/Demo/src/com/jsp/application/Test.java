package com.jsp.application;

import java.sql.*;

public class Test {

	public static void main(String[] args) 
	{
		
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedatabase","root","flower2V@#");
			final String str = "INSERT INTO employeedatabase.student (studentId, StudentName, StudentEmail, StudentAddre) VALUES (?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(str);
			pstm.setInt(1,101);
			pstm.setString(2, "hemanth");
			pstm.setString(3, "hemanth@gmail.com");
			pstm.setString(4, "shimogga");
			
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
