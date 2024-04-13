package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Note;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			Note note = new Note(title, content, new Date());
			//System.out.println(note.getId()+" "+note.getTitle());
			
			SessionFactory sf = new Configuration().configure().addAnnotatedClass(Note.class).buildSessionFactory();
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.save(note);
			tx.commit();
			s.close();
			sf.close();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<h1 style=\"text-align: center;\">Note added successfully...!</h1>");
			out.print("<h1 style=\"text-align: center;\"><a href=\"all_notes.jsp\">View All Notes</a></h1>");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
