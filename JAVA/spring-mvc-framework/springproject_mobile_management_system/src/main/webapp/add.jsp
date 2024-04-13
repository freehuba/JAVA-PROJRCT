<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Mobile</title>
</head>
<body>
		<h2>Add Mobile</h2>

		<form action="AddMobile" method="post">
		
			Enter MobileId : <input type="number" name="mobileId"/><br><br>
			Enter MobileName : <input type="text" name="mobileName"/><br><br>
			Enter MobileBrand : <input type="text" name="mobileBrand"/><br><br>
			Enter MobilePrice : <input type="number" name="mobilePrice"/><br><br>
			<input type="submit" value="Submit"/>
			<a href="index.jsp"><h1>Back</h1></a>
		
		</form>
</body>
</html>