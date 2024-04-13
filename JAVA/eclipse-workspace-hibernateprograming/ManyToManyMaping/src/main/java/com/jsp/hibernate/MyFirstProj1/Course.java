package com.jsp.hibernate.MyFirstProj1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course 
{
	@Id
	private int course_Id;
	private String course_Name;
	
	@ManyToMany(mappedBy = "clist")
	private List<Student> slist = new ArrayList<Student>();
	
	
	public List<Student> getSlist() {
		return slist;
	}
	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}
	public int getCourse_Id() {
		return course_Id;
	}
	public void setCourse_Id(int course_Id) {
		this.course_Id = course_Id;
	}
	public String getCourse_Name() {
		return course_Name;
	}
	public void setCourse_Name(String course_Name) {
		this.course_Name = course_Name;
	}
	@Override
	public String toString() {
		return "Course [course_Id=" + course_Id + ", course_Name=" + course_Name + "]";
	}
	
	
	
}
