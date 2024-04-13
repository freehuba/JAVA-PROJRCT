package com.jsp.componets.service;

import com.jsp.componets.model.Movie;

public interface MovieService 
{
	public void addMovie();
	
	public void findMovieById(int movieId);
	
	public void findMovieByName(String movieName);
	
	public void findAllMoviesByDirector(String movieDirector);
	
	public void findAllMoviesByVerdict(String movieType);
	
	public Movie findMovieByIdd(int movieId);
	
	public void listAllMovieNames();
	
	//public void findAllMoviesByActorName(String actorName);
	
}
