package com.jsp.componets;

import com.jsp.componets.service.ActorService;
import com.jsp.componets.service.ActorServiceImpl;
import com.jsp.componets.service.MovieService;
import com.jsp.componets.service.MovieServiceImpl;

public class App {

	public static void main(String[] args) 
	{
		ActorService cService = new ActorServiceImpl();
		//cService.addActor();
		cService.findActorByName("Yash");
		//cService.listAllActorNames();
		//cService.mapping();
//		cService.findActorByMovieTitle("Kgf");
		
		MovieService mService = new MovieServiceImpl();
		//mService.addMovie();
		//mService.findMovieById(23);
		//mService.findMovieByName("Tagaru");
		//mService.findAllMoviesByDirector("Prashanth Neel");
		//mService.findAllMoviesByVerdict("Action");
		//mService.listAllMovieNames();
	}

}
