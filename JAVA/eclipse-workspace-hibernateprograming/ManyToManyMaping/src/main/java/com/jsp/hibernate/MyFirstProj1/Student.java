package com.jsp.hibernate.MyFirstProj1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student 
{
	@Id
	private int student_Id;
	private String student_Name;
	
	@ManyToMany
	private List<Course> clist = new ArrayList<Course>();
	
	
	public List<Course> getClist() {
		return clist;
	}
	public void setClist(List<Course> clist) {
		this.clist = clist;
	}
	public int getStudent_Id() {
		return student_Id;
	}
	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}
	public String getStudent_Name() {
		return student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}
	@Override
	public String toString() {
		return "Student [student_Id=" + student_Id + ", student_Name=" + student_Name + "]";
	}
	
	
}
