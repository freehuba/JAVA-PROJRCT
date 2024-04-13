package com.jsp.hibernate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee 
{
	@Id
	private int employee_Id;
	private String employee_Name;
	private String employee_Email;
	private double employee_Salary;
	private String employee_Address;
	
	@ManyToOne
	private Company cmp;
	
	public Company getCmp() {
		return cmp;
	}
	public void setCmp(Company cmp) {
		this.cmp = cmp;
	}
	public int getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getEmployee_Name() {
		return employee_Name;
	}
	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}
	public String getEmployee_Email() {
		return employee_Email;
	}
	public void setEmployee_Email(String employee_Email) {
		this.employee_Email = employee_Email;
	}
	public double getEmployee_Salary() {
		return employee_Salary;
	}
	public void setEmployee_Salary(double employee_Salary) {
		this.employee_Salary = employee_Salary;
	}
	public String getEmployee_Address() {
		return employee_Address;
	}
	public void setEmployee_Address(String employee_Address) {
		this.employee_Address = employee_Address;
	}
	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_Name=" + employee_Name + ", employee_Email="
				+ employee_Email + ", employee_Salary=" + employee_Salary + ", employee_Address=" + employee_Address
				+ ", cmp=" + cmp + "]";
	}
	
	
	
	
	
	
}
