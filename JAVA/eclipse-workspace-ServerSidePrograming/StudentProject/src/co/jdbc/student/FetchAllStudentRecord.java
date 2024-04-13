package co.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchAllStudentRecord {

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","flower2V@#");
		final String query = "SELECT * FROM student_db.student;";
		PreparedStatement pstm = con.prepareStatement(query);
		
		ResultSet rs = pstm.executeQuery();
		int count = 0;
		System.out.println("Student-Id ...Student-Name...Student-Email  .....  Student-Address....Student-PhoneNo");
		while(rs.next())
		{
			count++;
			System.out.println(rs.getString(1)+ "    "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5));
		}
		
		System.out.println();
		System.out.println("Total number of Records : "+count);
		pstm.close();
		con.close();
	}

}
