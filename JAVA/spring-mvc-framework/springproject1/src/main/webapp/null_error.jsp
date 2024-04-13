<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Error!!!</title>
<link rel="stylesheet" href="style.css">

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="error-template">
					<h1>Oops!</h1>
					<h2>${message }</h2>
					<div class="error-details">Sorry, an error has occured,
						Requested page not found!</div>
					<div class="error-actions">
						<a href="index.jsp"
							class="btn btn-primary btn-lg"><span
							class="glyphicon glyphicon-home"></span> Take Me Home </a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>