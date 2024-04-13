package com.jsp.hibernate.MyFirstProj1;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonRunner {

	public static void main(String[] args) 
	{
		PersonV p = new PersonV();
		p.setPerson_Id(2010);
		p.setPerson_Name("Hemanth");
		
		Vehicle v1 = new Vehicle();
		v1.setVehicle_Id(232301);
		v1.setVehicle_Name("Car");
		
		Vehicle v2 = new Vehicle();
		v2.setVehicle_Id(232302);
		v2.setVehicle_Name("Bike");
		
		Vehicle v3 = new Vehicle();
		v3.setVehicle_Id(232303);
		v3.setVehicle_Name("Truck");
		
		p.setLv(Arrays.asList(v1,v2,v3));
		
		SessionFactory session = new Configuration().configure().addAnnotatedClass(PersonV.class).addAnnotatedClass(Vehicle.class).buildSessionFactory();
		
		Session ss = session.openSession();
		Transaction tx = ss.beginTransaction();
		
		ss.save(p);
		ss.save(v1);
		ss.save(v2);
		ss.save(v3);
		
		tx.commit();
		session.close();
		
		

	}

}
