package com.jsp.hibernate;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache (usage = CacheConcurrencyStrategy.READ_ONLY )
public class Company 
{
	@Id
	private int company_Id;
	private String company_Name;
	private String department;
	
	@OneToMany(mappedBy = "cmp" )
	private List<Employee> emplist = new ArrayList<Employee>();
	
	public List<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	public int getCompany_Id() {
		return company_Id;
	}
	public void setCompany_Id(int company_Id) {
		this.company_Id = company_Id;
	}
	public String getCompany_Name() {
		return company_Name;
	}
	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Company [company_Id=" + company_Id + ", company_Name=" + company_Name + ", department=" + department
				+ "]";
	}
	
	
	
	
	
}
