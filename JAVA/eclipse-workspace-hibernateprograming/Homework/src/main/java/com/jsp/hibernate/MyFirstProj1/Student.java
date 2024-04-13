package com.jsp.hibernate.MyFirstProj1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student 
{
	@Id
	private int student_id;
	private String student_Name;
	
	@OneToMany
	private List<Subject> lsub = new ArrayList<Subject>();

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_Name() {
		return student_Name;
	}

	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}

	public List<Subject> getLsub() {
		return lsub;
	}

	public void setLsub(List<Subject> lsub) {
		this.lsub = lsub;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_Name=" + student_Name + ", lsub=" + lsub + "]";
	}
	
	
}
