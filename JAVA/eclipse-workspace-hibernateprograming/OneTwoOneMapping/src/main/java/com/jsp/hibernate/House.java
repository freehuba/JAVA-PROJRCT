package com.jsp.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class House 
{
	@Id
	private int house_Id;
	private String house_Loc;
	private double house_Rent;
	
	@ManyToOne
	private Owner owner;

	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getHouse_Id() {
		return house_Id;
	}
	public void setHouse_Id(int house_Id) {
		this.house_Id = house_Id;
	}
	public String gethouse_Loc() {
		return house_Loc;
	}
	public void sethouse_Loc(String house_Loc) {
		this.house_Loc = house_Loc;
	}
	public double getHouse_Rent() {
		return house_Rent;
	}
	public void setHouse_Rent(double house_Rent) {
		this.house_Rent = house_Rent;
	}
	@Override
	public String toString() {
		return "House [house_Id=" + house_Id + ", house_Loc=" + house_Loc + ", house_Rent=" + house_Rent + "]";
	}
	
	

}
