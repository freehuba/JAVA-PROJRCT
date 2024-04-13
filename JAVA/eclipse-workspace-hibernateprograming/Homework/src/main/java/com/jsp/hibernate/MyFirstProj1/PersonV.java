package com.jsp.hibernate.MyFirstProj1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PersonV 
{
	@Id
	private int person_Id;
	private String person_Name;
	
	@OneToMany
	private List<Vehicle> lv = new ArrayList<Vehicle>();

	public int getPerson_Id() {
		return person_Id;
	}

	public void setPerson_Id(int person_Id) {
		this.person_Id = person_Id;
	}

	public String getPerson_Name() {
		return person_Name;
	}

	public void setPerson_Name(String person_Name) {
		this.person_Name = person_Name;
	}

	public List<Vehicle> getLv() {
		return lv;
	}

	public void setLv(List<Vehicle> lv) {
		this.lv = lv;
	}

	@Override
	public String toString() {
		return "PersonV [person_Id=" + person_Id + ", person_Name=" + person_Name + ", lv=" + lv + "]";
	}
	
	
}
