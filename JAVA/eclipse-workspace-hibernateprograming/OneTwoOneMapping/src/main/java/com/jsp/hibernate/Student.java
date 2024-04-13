package com.jsp.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student 

{
	@Id
	private int sId;
	private String sName;
	private long sContact;
	private double sPercentile;
	
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sContact=" + sContact + ", sPercentile=" + sPercentile
				+ "]";
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public long getsContact() {
		return sContact;
	}
	public void setsContact(long sContact) {
		this.sContact = sContact;
	}
	public double getsPercentile() {
		return sPercentile;
	}
	public void setsPercentile(double sPercentile) {
		this.sPercentile = sPercentile;
	}
	

}
