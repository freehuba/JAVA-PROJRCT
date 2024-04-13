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

@WebServlet("/addCar")
public class AddCarServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int carId = Integer.parseInt(req.getParameter("carId"));
		String carModel = req.getParameter("carModel");
		String carBrand = req.getParameter("carBrand");
		Double carPrice = Double.parseDouble(req.getParameter("carPrice"));
		
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		
		Car car = new Car();
		car.setCarId(carId);
		car.setCarModel(carModel);
		car.setCarBrand(carBrand);
		car.setCarPrice(carPrice);
		
		ss.save(car);
		tx.commit();
		ss.close();
		sf.close();
		
		System.out.println("car inserted");
		resp.sendRedirect("AddCar.jsp");
		
		
	}
}
