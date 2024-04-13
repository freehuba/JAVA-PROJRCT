<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Mobile</title>
</head>
<body>

<% 
final String jdbc_Driver = "com.mysql.cj.jdbc.Driver";
final String jdbc_Url = "jdbc:mysql://localhost:3306/tms";
final String user_Name = "root";
final String user_Password = "flower2V@#";
final String dql_query= "SELECT * FROM tms.mobile where mobileId = ?";

int mobileId = Integer.parseInt(request.getParameter("mobileId"));

Class.forName(jdbc_Driver);
Connection con =  DriverManager.getConnection(jdbc_Url, user_Name, user_Password);
PreparedStatement pstm =  con.prepareStatement(dql_query);
pstm.setInt(1, mobileId);
ResultSet rs =  pstm.executeQuery();

while(rs.next())
{

%>
		<h2>Update Mobile</h2>

		<form action="UpdateMobile" method="post">
		
			Enter MobileId : <input type="number" name="mobileId" value="<%= rs.getInt(1) %>" readonly="readonly" /><br><br>
			Enter MobileName : <input type="text" name="mobileName" value="<%= rs.getString(2) %>" /><br><br>
			Enter MobileBrand : <input type="text" name="mobileBrand" value="<%= rs.getString(3) %>"/><br><br>
			Enter MobilePrice : <input type="number" name="mobilePrice"  value="<%= rs.getDouble(4) %>"/><br><br>
			<input type="submit" value="Submit"/>
			<a href="DisplayAll.jsp"><h1>Back</h1></a>
		
		</form>
		
		<%  } %>
</body>
</html>