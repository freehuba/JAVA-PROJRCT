package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Note;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteServlet() 
    {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			
			SessionFactory sf = new Configuration().configure().addAnnotatedClass(Note.class).buildSessionFactory();
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			
			Note note =(Note) s.get(Note.class, noteId);
			s.delete(note);
			
			tx.commit();
			s.close();
			sf.close();
			
			response.sendRedirect("all_notes.jsp");
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}



}
