package com.jsp.componets.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.jsp.componets.model.Actor;
import com.jsp.componets.model.Movie;

public class ActorServiceImpl implements ActorService {
	Scanner s = new Scanner(System.in);
	MovieService movieService = new MovieServiceImpl();
	
	@Override
	public void addActor() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		while (true) {
			etx.begin();
			Actor insertActor = insertActor();
			em.persist(insertActor);
			etx.commit();
			System.out.println("do you want insert more records[y/n]");
			String option = s.nextLine();
			if (option.equalsIgnoreCase("n"))
				break;
		}

		System.out.println("Thank you ....!");
		em.close();
		emf.close();

	}

	public Actor insertActor() {
		Actor actor = new Actor();
		System.out.println("Enter actorName");
		String actorName = s.nextLine();
		System.out.println("Enter actorAge");
		int actorAge = s.nextInt();
		s.nextLine();
		System.out.println("Enter actorAddress");
		String actorAddress = s.nextLine();
		System.out.println("Enter industry");
		String industry = s.nextLine();
		System.out.println("Enter nationality");
		String nationality = s.nextLine();

		actor.setActorName(actorName);
		actor.setActorAge(actorAge);
		actor.setActorAddress(actorAddress);
		actor.setIndustry(industry);
		actor.setNationality(nationality);

		return actor;
	}

	@Override
	public void findActorByName(String actorName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> query = cb.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root);
		query.where(cb.equal(root.get("actorName"), actorName));

		Query query2 = em.createQuery(query);
		List<Actor> resultList = query2.getResultList();

		for (Actor actor : resultList) {
			System.out.println(actor);
		}

		em.close();
		emf.close();
	}

	@Override
	public void findActorByIndustry(String industry) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Actor> query = cb.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);
		query.select(root);
		query.where(cb.equal(root.get("actorName"), industry));

		Query query2 = em.createQuery(query);
		List<Actor> resultList = query2.getResultList();

		for (Actor actor : resultList) {
			System.out.println(actor);
		}

		em.close();
		emf.close();

	}

	@Override
	public void listAllActorNames() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Actor> root = query.from(Actor.class);
		query.multiselect( root.get("actorId"),root.get("actorName"));

		Query query2 = em.createQuery(query);
		List<Object[]> resultList = query2.getResultList();

		for (Object[] actor : resultList) {
			System.out.println(actor[0] + "       " + actor[1]);
		}

		em.close();
		emf.close();
	}

	@Override
	public Actor findActorById(int actorId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		Actor actor = em.find(Actor.class, actorId);

		em.close();
		emf.close();
		return actor;
	}

	@Override
	public void mapping() 
	{
		listAllActorNames();
		movieService.listAllMovieNames();
		System.out.println("Enter Movie Id to Add Actors");
		int movieId = s.nextInt();
		Movie movie = movieService.findMovieByIdd(movieId);
		List<Actor> list = new ArrayList<>();
		while(true)
		{
			System.out.println("Choose Actor Id");
			int actorId = s.nextInt();
			s.nextLine();
			list.add(findActorById(actorId));
			System.out.println("Do you want add one More actor to "+ movie.getMovieTitle()+"[y/n]");
			String option = s.nextLine();
			if (option.equalsIgnoreCase("n"))
			{
				break;
			}
		}
		
		movie.setActorList(list);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		
		em.merge(movie);
		
		etx.commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void findActorByMovieTitle(String movieTitle) 
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> query1 = cb.createTupleQuery();
		Root<Actor> root = query1.from(Actor.class);
		Join<Object, Object> movie = root.join("actorId", JoinType.LEFT);
		
		ParameterExpression<String> parameter = cb.parameter(String.class);
		query1.where(cb.equal(root.get("MovieTitle"), parameter));
		
		TypedQuery<Tuple> query = em.createQuery(query1);
		query.setParameter(parameter, movieTitle);
		List<Tuple> resultList = query.getResultList();
		
		System.out.println(resultList);
		
		etx.commit();
		em.close();
		emf.close();
	}

}
