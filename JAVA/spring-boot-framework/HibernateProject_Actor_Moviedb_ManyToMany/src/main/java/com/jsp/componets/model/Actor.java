package com.jsp.componets.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int actorId;
	private String actorName;
	private int actorAge;
	private String actorAddress;
	private String industry;
	private String nationality;
	
	@ManyToMany
	private List<Movie> movieList = new ArrayList<>();
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public int getActorAge() {
		return actorAge;
	}
	public void setActorAge(int actorAge) {
		this.actorAge = actorAge;
	}
	public String getActorAddress() {
		return actorAddress;
	}
	public void setActorAddress(String actorAddress) {
		this.actorAddress = actorAddress;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", actorAge=" + actorAge + ", actorAddress="
				+ actorAddress + ", industry=" + industry + ", nationality=" + nationality + "]";
	}
	
	
}
