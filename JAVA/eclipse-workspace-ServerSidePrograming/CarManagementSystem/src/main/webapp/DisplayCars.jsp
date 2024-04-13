<%@page import="java.util.List"%>
<%@page import="org.hibernate.cfg.*"%>
<%@page import="org.hibernate.*"%>
<%@page import="com.jsp.servlet.Car" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		Query query = ss.createQuery("from Car c");
		List<Car> carlist =query.list();
		
	%>
	<table border=5 cellspacing=0 cellpadding=20 align=center style="border: 2px solid blue">
	  <thead style="color: rgb(255, 0, 0); font-size: 20px; font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">
		<th>Car Id</th>
		<th>Car Model</th>
		<th>Car Name</th>
		<th>Car Price</th>
		<th>Update</th>
		<th>Delete</th>
	</thead>
	<% for(Car car : carlist) {  %>
			
	<tr style="color: brown; font-size: 15px; font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;">
		<td><%= car.getCarId() %></td>
		<td><%= car.getCarModel()%></td>
		<td><%= car.getCarBrand() %></td>
		<td><%= car.getCarPrice()%></td>
		<td><a href="UpdateCar.jsp?carId=<%= car.getCarId() %>" >UPDATE</a></td>
		<td><a href="DeleteCar?carId=<%= car.getCarId() %>">DELETE</a></td>
	</tr>
			
			
	<% }	
		tx.commit();
		ss.close();
		sf.close();
	%>
</body>
</html>