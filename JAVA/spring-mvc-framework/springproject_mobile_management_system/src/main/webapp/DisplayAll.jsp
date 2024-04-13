<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  ResultSet rs = (ResultSet) request.getAttribute("mobile"); %>
	
	<table boredrcolor="red" border="3" cellpadding="13" align="center" style="border-color: #ff0063;" >
	<thead style="color: red; font-size: 20px;"">
		<th> MobileId</th>
		<th> MobileName</th>
		<th> MobileBrand</th>
		<th> MobilePrice</th>
		<th> UPDATE</th>
		<th> DELETE</th>
	</thead>
	
	<%  while(rs.next())
	{
	%>
	<tr>
		<td> <%= rs.getInt(1) %></td>
		<td> <%= rs.getString(2) %></td>
		<td> <%= rs.getString(3) %></td>
		<td> <%= rs.getDouble(4) %></td>
		<td> <a href="update.jsp?mobileId=<%= rs.getInt(1) %>" style="text-decoration: none; color: green">UPDATE</a></td>
		<td> <a href="DeleteMobile?mobileId=<%= rs.getInt(1) %>" style="text-decoration: none; color: red">DELETE</a></td>
	</tr>
		
	<% 
	}
		
	%>
	
	<tr style="background-color: #b2bfd3">
		<td colspan="6" style="text-align: center;"><a href="index.jsp">Back</a></td>
	</tr>
	
	</table>

</body>
</html>