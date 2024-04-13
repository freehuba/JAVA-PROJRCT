package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/DeleteCar")
public class DeleteCar extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int carId = Integer.parseInt(req.getParameter("carId"));
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		Car car = ss.get(Car.class, carId);
		
		ss.delete(car);
		tx.commit();
		ss.close();
		sf.close();
		
		System.out.println("car Deleted");
		resp.sendRedirect("DisplayCars.jsp");
	}
}
