<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.cfg.*"%>
<%@page import="org.hibernate.*"%>
<%@page import="com.jsp.servlet.Car" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int carId = Integer.parseInt(request.getParameter("carId"));
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		Car car = ss.get(Car.class, carId);
	
	%>

	<form action="updateCar" method="post">
		Car-Id : <input type="number" name="carId" value="<%= car.getCarId() %>" readonly="readonly"><br><br>
		Car-Model : <input type="text" name="carModel" value="<%= car.getCarModel() %>" ><br><br>
		Car-Brand : <input type="text" name="carBrand"  value="<%= car.getCarBrand() %>"><br><br>
		Car-Price : <input type="number" name="carPrice" value="<%= car.getCarPrice() %>"><br><br>
	<input type="submit" value="Update">
</body>
</html>