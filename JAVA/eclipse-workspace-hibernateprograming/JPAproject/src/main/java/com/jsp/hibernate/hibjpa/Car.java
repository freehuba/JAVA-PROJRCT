package com.jsp.hibernate.hibjpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car 
{
	@Id
	private int carId;
	private String carName;
	private double carPrice;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", carPrice=" + carPrice + "]";
	}
	
	
}
