<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<form action="addCar" method="post">
		Car-Id : <input type="number" name="carId" placeholder="Enter Car-Id.." required="required"><br><br>
		Car-Model : <input type="text" name="carModel" placeholder="Enter Car-Model.." required="required"><br><br>
		Car-Brand : <input type="text" name="carBrand" placeholder="Enter Car-Name.." required="required"><br><br>
		Car-Price : <input type="number" name="carPrice" placeholder="Enter Car-Price.." required="required"><br><br>
	<input type="submit" value="ADD">
	
</body>
</html>