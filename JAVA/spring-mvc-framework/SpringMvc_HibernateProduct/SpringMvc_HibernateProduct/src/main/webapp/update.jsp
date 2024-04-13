<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="springmvc_product.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UpdateProduct.com</title>
</head>
<body>
<% 
int pId =  Integer.parseInt(request.getParameter("productId")); 
SessionFactory sf = new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
Session ss =  sf.openSession();
Transaction tx = ss.beginTransaction();

Product product =  ss.get(Product.class, pId);

tx.commit();
ss.close();
sf.close();
	
%>

<form action="updateProduct" method="post">
    Enter ProductId:<input type="number" name="productId" value="<%= product.getProductId()%>" readonly="readonly"><br><br>
    Enter ProductName:<input type="text" name="productName" value="<%= product.getProductName()%>"><br><br>
    Enter ProductPrice:<input type="number" name="productPrice" value="<%= product.getProductPrice()%>"><br><br>
    <input type="submit" value="Update">               
 </form>

</body>
</html>