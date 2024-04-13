<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.NativeQuery"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.hibernate.cfg.*" %> 
<%@ page import="org.hibernate.*" %>  
<%@ page import="com.entities.Note" %>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AllNotes.com</title>

<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
			<%@include file="navbar.jsp"%><br>
			
		<h1 class="text-uppercase">All Notes :</h1>
			
			<div class="row">
				<div class="col-12">
				
				<%
					
					SessionFactory sf = new Configuration().configure().addAnnotatedClass(Note.class).buildSessionFactory();
					Session s = sf.openSession();
					
					Query query = s.createQuery("from Note n ORDER BY n.addedDate DESC");
					List<Note> list =  query.list();
				
					for(Note note : list)
					{
				%> 
				
				
						
			<div class="card mt-3">
			  <img class="card-img-top m-3 mx-auto" style="width: 100px" src="img/notes.png" alt="Card image cap">
			  <div class="card-body px-5">
			    <h5 class="card-title"><%= note.getTitle() %></h5>
			    <p class="card-text"><%= note.getContent() %></p>
			    <p class="text-primary"><b><%= note.getAddedDate() %></b></p>
			    
			    <div class="container  text-center mt-2">
				    <a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
				    <a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-primary">Update</a>
			    </div>
			    
			  </div>
			  
			</div>
						
						
				<% 
					}
					
					s.close();
					sf.close();
			
				%>
				
				</div>
			
			</div>
					
	</div>
</body>
</html>