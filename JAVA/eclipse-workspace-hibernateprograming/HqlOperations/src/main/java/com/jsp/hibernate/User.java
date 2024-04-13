package com.jsp.hibernate;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User 
{
	@Id
	private int userId;
	private String userFName;
	private String userLname;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFName() {
		return userFName;
	}
	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}
	public String getUserLname() {
		return userLname;
	}
	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFName=" + userFName + ", userLname=" + userLname + "]";
	}
	
	
}
