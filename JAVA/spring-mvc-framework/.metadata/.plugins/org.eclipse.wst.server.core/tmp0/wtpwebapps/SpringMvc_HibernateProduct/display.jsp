<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@page import="java.util.*" %>
<%@page import="springmvc_product.model.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayProduct.com</title>
</head>
<body>

<% List<Product> product = (List<Product>) request.getAttribute("product"); %>

	<table boredrcolor="red" border="3" cellpadding="13" align="center" style="border-color: blue;" >
	<h1 style="text-align: center;">${message}</h1>
	<thead style="color: red; font-size: 20px;"">
		<th> ProductId</th>
		<th> ProductName</th>
		<th> ProductPrice</th>
		<th> UPDATE</th>
		<th> DELETE</th>
	</thead>
	
	<% 
		for(Product p : product)
		{
	%>
	 <tr>
		<td> <%= p.getProductId() %></td>
		<td> <%= p.getProductName() %></td>
		<td> ₹ <%= p.getProductPrice() %>  </td>
		<td> <a href="update.jsp?productId=<%= p.getProductId() %>" style="text-decoration: none; color: green">UPDATE</a></td>
		<td> <a href="deletProduct?productId=<%= p.getProductId() %>" style="text-decoration: none; color: red">DELETE</a></td>
		
	  </tr>
	<% 		
		}
	%>
	
	<tr style="background-color: #b2bfd3">
		<td colspan="5" style="text-align: center;"><a href="index.jsp">Back</a></td>
	</tr>
	
	</table>
</body>
</html>