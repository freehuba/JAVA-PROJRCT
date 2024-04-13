<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<fieldset style="border: 5px solid red; width: 400px">
<legend style="font-size: 25px; color: red"> Update Employee Details.....!</legend>
	<form action="update_employee">
		Enter Employee-Id : <input type="text" name="employee_id" required="required"><br><br>
		Employee-Name : <input type="text" name="employee_name" required="required"><br><br>
		Employee-Email : <input type="text" name="employee_email" required="required"><br><br>
		Employee-Address : <input type="text" name="employee_address" required="required"><br><br>
		<input type="submit" value="Submit">
		<input type="reset" value="Reset"> 
	</form>
</fieldset>
</center>
</body>
</html>