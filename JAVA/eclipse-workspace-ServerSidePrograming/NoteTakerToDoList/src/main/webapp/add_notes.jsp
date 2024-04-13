<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddNotes.com</title>
<%@include file="all_js_css.jsp"%>


</head>
<body>
	<div class="container">
			<%@include file="navbar.jsp"%><br>
						
	<h1>Please Fill Your Note Details..!</h1>
			
	<!-- this is form feild -->
	
	<form action="SaveNoteServlet" method="post">
	
		  <div class="form-group">
		    <label for="exampleInputEmail1">Note Title</label>
		    <input type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter here" required="required">
		  </div>
		  
		  <div class="form-group">
		    <label for="content">Note Content</label>
		    <textarea id="content" name="content" placeholder="Enter Your Content here" class="form-control" style="height: 250px" required="required"></textarea>
		  </div>
		  
		  <div class="container text-center">
		  		<button type="submit" class="btn btn-primary">Add</button>
		  </div>
	</form>
				
			
	</div>
</body>
</html>










