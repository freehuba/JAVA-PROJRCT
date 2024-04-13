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
<legend style="font-size: 25px; color: red"> Employee Form.....!</legend>
	<form action="deleteEmployee" method="post">
		Employee-Id : <input type="text" name="employee_id" required="required" placeholder="Enter you Employee-Id To Delete...!"><br><br>
		<input type="submit" value="Save">
		<input type="reset" value="Reset"> 
	</form>
</fieldset>
</center>
</body>
</html>