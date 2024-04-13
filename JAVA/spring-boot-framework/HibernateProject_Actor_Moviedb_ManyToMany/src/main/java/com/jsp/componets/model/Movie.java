package com.jsp.componets.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movie 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String MovieTitle;
	private String MovieGeneration;
	private String MovieDirector;
	private int boxOfficeCollection;
	private String boxOfficeVerdict;
	private String movieLanguage;
	
	@ManyToMany
	private List<Actor> actorList = new ArrayList<>();
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return MovieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		MovieTitle = movieTitle;
	}
	public String getMovieGeneration() {
		return MovieGeneration;
	}
	public void setMovieGeneration(String movieGeneration) {
		MovieGeneration = movieGeneration;
	}
	public String getMovieDirector() {
		return MovieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		MovieDirector = movieDirector;
	}
	public int getBoxOfficeCollection() {
		return boxOfficeCollection;
	}
	public void setBoxOfficeCollection(int boxOfficeCollection) {
		this.boxOfficeCollection = boxOfficeCollection;
	}
	public String getBoxOfficeVerdict() {
		return boxOfficeVerdict;
	}
	public void setBoxOfficeVerdict(String boxOfficeVerdict) {
		this.boxOfficeVerdict = boxOfficeVerdict;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public List<Actor> getActorList() {
		return actorList;
	}
	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", MovieTitle=" + MovieTitle + ", MovieGeneration=" + MovieGeneration
				+ ", MovieDirector=" + MovieDirector + ", boxOfficeCollection=" + boxOfficeCollection
				+ ", boxOfficeVerdict=" + boxOfficeVerdict + ", movieLanguage=" + movieLanguage + "]";
	}
	
	
	
}
