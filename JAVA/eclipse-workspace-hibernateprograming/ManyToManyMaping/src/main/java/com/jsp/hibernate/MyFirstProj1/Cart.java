package com.jsp.hibernate.MyFirstProj1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cart 
{
	@Id
	private int cId;
	private int cCapacity;
	
	@ManyToMany
	private List<Item> ilist = new ArrayList<Item>();
	
	
	public List<Item> getIlist() {
		return ilist;
	}
	public void setIlist(List<Item> ilist) {
		this.ilist = ilist;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getcCapacity() {
		return cCapacity;
	}
	public void setcCapacity(int cCapacity) {
		this.cCapacity = cCapacity;
	}
	
	
}
