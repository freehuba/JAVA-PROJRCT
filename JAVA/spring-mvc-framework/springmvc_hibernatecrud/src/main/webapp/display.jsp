<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="springmvc_hibernate.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<User> list = (List<User>) request.getAttribute("user");
	%>
	
	<table boredrcolor="red" border="3" cellpadding="13" align="center" style="border-color: blue;" >
	<thead style="color: red; font-size: 20px;"">
		<th> UserId</th>
		<th> UserName</th>
		<th> UserPassword</th>
	</thead>
	
	<%
		for(User l : list)
				{
		%>
	 <tr>
		<td> <%= l.getUserId() %></td>
		<td> <%= l.getUserName() %></td>
		<td> <%= l.getUserPassword() %></td>
	  </tr>
	<% 		
		}
	%>
	
	<tr style="background-color: #b2bfd3">
		<td colspan="3" style="text-align: center;"><a href="index.jsp">Back</a></td>
	</tr>
	
	</table>
</body>
</html>