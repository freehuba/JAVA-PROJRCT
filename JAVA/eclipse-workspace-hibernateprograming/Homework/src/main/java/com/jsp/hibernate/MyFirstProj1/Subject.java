package com.jsp.hibernate.MyFirstProj1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject 
{
	@Id
	private int subject_id;
	private String subject_Name;
	
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getSubject_Name() {
		return subject_Name;
	}
	public void setSubject_Name(String subject_Name) {
		this.subject_Name = subject_Name;
	}
	@Override
	public String toString() {
		return "Subject [subject_id=" + subject_id + ", subject_Name=" + subject_Name + "]";
	}
	
	
}
