<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.cfg.*" %> 
<%@ page import="org.hibernate.*" %>  
<%@ page import="com.entities.Note" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update.com</title>

<%@include file="all_js_css.jsp"%>
</head>
<body>
		<div class="container">
			<%@include file="navbar.jsp"%><br>
			
		<h1>Update Your Note :</h1>
		
		<%
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			SessionFactory sf = new Configuration().configure().addAnnotatedClass(Note.class).buildSessionFactory();
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			Note note = (Note) s.get(Note.class, noteId);
		
		%>
		
		<form action="UpdateServlet" method="post">
		
			<input type="hidden" name="noteId" value="<%=  note.getId()%>">
	
		  <div class="form-group">
		  
		    <label for="exampleInputEmail1">Note Title</label>
		    <input type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter here" required="required"
		    value="<%= note.getTitle()   %>">
		   		  
		  </div>
		  
		  <div class="form-group">
		    <label for="content">Note Content</label>
		    <textarea id="content" name="content" placeholder="Enter Your Content here" class="form-control" style="height: 250px" required="required">
		    <%= note.getContent()%></textarea>
		  </div>
		  
		  <div class="container text-center">
		  		<button type="submit" class="btn btn-success">Save Your Note</button>
		  </div>
	</form>
		
		
		</div>
</body>
</html>