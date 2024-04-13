package com.jsp.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner 
{
	@Id
	private int owner_Id;
	private String owner_Name;
	
	@OneToMany(mappedBy = "owner")
	private List<House> lhouse = new ArrayList<House>();
	
	public List<House> getLhouse() {
		return lhouse;
	}
	public void setLhouse(List<House> lhouse) {
		this.lhouse = lhouse;
	}
	public int getOwner_Id() {
		return owner_Id;
	}
	public void setOwner_Id(int owner_Id) {
		this.owner_Id = owner_Id;
	}
	public String getOwner_Name() {
		return owner_Name;
	}
	public void setOwner_Name(String owner_Name) {
		this.owner_Name = owner_Name;
	}
	@Override
	public String toString() {
		return "Owner [owner_Id=" + owner_Id + ", owner_Name=" + owner_Name + ", lhouse=" + lhouse + "]";
	}
	
	
	
}
