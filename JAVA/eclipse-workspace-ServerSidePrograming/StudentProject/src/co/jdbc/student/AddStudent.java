package co.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddStudent {

	public static void main(String[] args) throws Exception 
	{
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
		final String query = "INSERT INTO student_db.student (studentusn, studentname, studentemail, studentaddress, studentphoneno) VALUES (?,?,?,?,?)";
		PreparedStatement pstm = con.prepareStatement(query);
		Scanner sc = new Scanner(System.in);
		int count=0;
		while(true)
		{
			count++;
			System.out.println("Enter Student-Usn :");
			String std_usn = sc.nextLine();
			System.out.println("Enter Student-Name :");
			String std_name = sc.nextLine();
			System.out.println("Enter Student-Email :");
			String std_EMAIL = sc.nextLine();
			System.out.println("Enter Student-Address :");
			String std_Add = sc.nextLine();
			System.out.println("Enter Student-PhoneNumber :");
			String std_phone = sc.nextLine();
			
		
			pstm.setString(1, std_usn);
			pstm.setString(2, std_name);
			pstm.setString(3, std_EMAIL);
			pstm.setString(4, std_Add);
			pstm.setString(5, std_phone);
			
			int x = pstm.executeUpdate();
			
			if(x>0)
			{
				System.out.println("Record Inserted Successufully...!");
			}
			
			else
			{
				System.out.println("Failed in inserting record...!");
			
			}
			System.out.println();
			System.out.println("Do you Want To Insert One More Record[y/n]...!");
			String choice = sc.nextLine();
			if(choice.equalsIgnoreCase("n"))
				break;
		}
		
		System.out.println("Total number of Records : "+count);
		pstm.close();
		con.close();
		
	}

}
