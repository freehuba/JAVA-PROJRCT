package com.jsp.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport 
{
	@Id
	private int passId;
	private String passName;
	
	public int getPassId() {
		return passId;
	}
	public void setPassId(int passId) {
		this.passId = passId;
	}
	public String getPassName() {
		return passName;
	}
	public void setPassName(String passName) {
		this.passName = passName;
	}
	@Override
	public String toString() {
		return "Passport [passId=" + passId + ", passName=" + passName + "]";
	}
	
	
}
