package com.jsp.hibernate.hibjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarRunner {

	public static void main(String[] args)
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		
		etx.begin();
		Car car = em.find(Car.class, 110);

		
//		Car merge = em.merge(car);
//		merge.setCarName("audi");
//		merge.setCarPrice(60000);
		
//		em.remove(car);
		
		etx.commit();
		em.close();
		emf.close();

	}

}