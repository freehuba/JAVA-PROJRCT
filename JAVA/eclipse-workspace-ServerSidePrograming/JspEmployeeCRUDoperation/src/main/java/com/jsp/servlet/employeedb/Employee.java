package com.jsp.servlet.employeedb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee 
{
	@Id
	private int employee_Id;
	private String employee_Name;
	private String employee_Email;
	private String employee_Address;
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
	public String getEmployee_Address() {
		return employee_Address;
	}
	public void setEmployee_Address(String employee_Address) {
		this.employee_Address = employee_Address;
	}
	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_Name=" + employee_Name + ", employee_Email="
				+ employee_Email + ", employee_Address=" + employee_Address + "]";
	}
	
	

}
