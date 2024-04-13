package com.jsp.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person 
{
	@Id
	private int pId;
	private String pName;
	private long pContact;
	
	@OneToOne
	private Passport pass ;
	
	/*@OneToOne
	private Pan pan;
	
	
	public Pan getPan() {
		return pan;
	}
	public void setPan(Pan pan) {
		this.pan = pan;
	}*/
	
	
	
	public int getpId() {
		return pId;
	}
	public Passport getPass() {
		return pass;
	}
	public void setPass(Passport pass) {
		this.pass = pass;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public long getpContact() {
		return pContact;
	}
	public void setpContact(long pContact) {
		this.pContact = pContact;
	}
	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", pContact=" + pContact + "]";
	}
	
	
}
