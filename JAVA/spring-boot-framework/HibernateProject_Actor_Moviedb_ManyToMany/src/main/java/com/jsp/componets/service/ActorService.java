package com.jsp.componets.service;

import com.jsp.componets.model.Actor;

public interface ActorService 
{
	public void addActor();
	
	public void findActorByName(String actorName);
	
	public Actor findActorById(int actorId);
	
	public void findActorByIndustry(String industry);
	
	public void listAllActorNames();
	
	public void mapping();
	
	public void findActorByMovieTitle(String movieTitle);
	
}
