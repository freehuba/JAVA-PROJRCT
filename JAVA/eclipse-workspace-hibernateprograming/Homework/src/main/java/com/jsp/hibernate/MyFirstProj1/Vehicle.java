package com.jsp.hibernate.MyFirstProj1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle 
{
	@Id
	private int vehicle_Id;
	private String vehicle_Name;
	public int getVehicle_Id() {
		return vehicle_Id;
	}
	public void setVehicle_Id(int vehicle_Id) {
		this.vehicle_Id = vehicle_Id;
	}
	public String getVehicle_Name() {
		return vehicle_Name;
	}
	public void setVehicle_Name(String vehicle_Name) {
		this.vehicle_Name = vehicle_Name;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicle_Id=" + vehicle_Id + ", vehicle_Name=" + vehicle_Name + "]";
	}
	
	
}
