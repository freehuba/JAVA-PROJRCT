package com.jsp.componets.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jsp.componets.model.Actor;
import com.jsp.componets.model.Movie;

public class MovieServiceImpl implements MovieService
{
	Scanner s = new Scanner(System.in);	
	
	@Override
	public void addMovie() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		while(true)
		{
			etx.begin();
			Movie insertMovie = insertMovie();
			em.persist(insertMovie);
			etx.commit();
			System.out.println("do you want insert more records[y/n]");
			String option = s.nextLine();
			if(option.equalsIgnoreCase("n"))
				break;
		}
		System.out.println("Thank you ....!");
		em.close();
		emf.close();
	}
	
	
	public Movie insertMovie()
	{
		Movie movie = new Movie();
		System.out.println("Enter MovieTitle");
		String movieTitle = s.nextLine();
		System.out.println("Enter MovieType");
		String movieType = s.nextLine();
		System.out.println("Enter MovieDirector");
		String movieDirector = s.nextLine();
		System.out.println("Enter Movie BoxOffice Collection");
		int boxOfficeCollection = s.nextInt();
		s.nextLine();
		System.out.println("Enter Movie BoxOffice Verdict");
		String boxOfficeVerdict = s.nextLine();
		System.out.println("Enter Movie Language");
		String movieLanguage = s.nextLine();
		
		movie.setMovieTitle(movieTitle);
		movie.setMovieGeneration(movieType);
		movie.setMovieDirector(movieDirector);
		movie.setBoxOfficeCollection(boxOfficeCollection);
		movie.setBoxOfficeVerdict(boxOfficeVerdict);
		movie.setMovieLanguage(movieLanguage);
		
		return movie;
	}


	@Override
	public void findMovieById(int movieId) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		
		Movie movie = em.find(Movie.class, movieId);		
		System.out.println(movie);
		
		em.close();
		emf.close();
		
	}


	@Override
	public void findMovieByName(String movieName) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
		Root<Movie> root = query.from(Movie.class);
		query.select(root);
		query.where(cb.equal(root.get("MovieTitle"), movieName));
		
		Query query2 = em.createQuery(query);
		List<Movie> resultList = query2.getResultList();
		
		for(Movie movie : resultList)
		{
			System.out.println(movie);
		}

		em.close();
		emf.close();
	}


	@Override
	public void findAllMoviesByDirector(String movieDirector) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
		Root<Movie> root = query.from(Movie.class);
		query.select(root);
		query.where(cb.equal(root.get("MovieDirector"), movieDirector));
		
		Query query2 = em.createQuery(query);
		List<Movie> resultList = query2.getResultList();
		
		for(Movie movie : resultList)
		{
			System.out.println(movie);
		}

		em.close();
		emf.close();
		
	}


	@Override
	public void findAllMoviesByVerdict(String movieType) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
		Root<Movie> root = query.from(Movie.class);
		query.select(root);
		query.where(cb.equal(root.get("MovieGeneration"), movieType));
		
		Query query2 = em.createQuery(query);
		List<Movie> resultList = query2.getResultList();
		
		for(Movie movie : resultList)
		{
			System.out.println(movie);
		}

		em.close();
		emf.close();
		
	}


	@Override
	public Movie findMovieByIdd(int movieId) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		
		Movie movie = em.find(Movie.class, movieId);		
		
		em.close();
		emf.close();
		
		return movie;
	}


	@Override
	public void listAllMovieNames() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hemanth");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Movie> root = query.from(Movie.class);
		query.multiselect(root.get("movieId"),root.get("MovieTitle"));

		Query query2 = em.createQuery(query);
		List<Object[]> resultList = query2.getResultList();

		for (Object[] movie : resultList) {
			System.out.println(movie[0] + "       " + movie[1]);
		}

		em.close();
		emf.close();
		
	}
		
	}
