package com.jsp.servlet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car 
{
	@Id
	private int carId;
	private String carModel;
	private String carBrand;
	private double carPrice;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public double getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carModel=" + carModel + ", carBrand=" + carBrand + ", carPrice=" + carPrice
				+ "]";
	}
	
	
}
