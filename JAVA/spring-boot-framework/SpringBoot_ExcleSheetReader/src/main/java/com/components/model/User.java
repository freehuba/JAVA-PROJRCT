package com.components.model;


public class User 
{
	private int Index;
	private String UserId;
	private String FirstName;
	private String Sex;
	
	public int getIndex() {
		return Index;
	}
	public void setIndex(int index) {
		Index = index;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public User(int index, String userId, String firstName, String sex) {
		super();
		Index = index;
		UserId = userId;
		FirstName = firstName;
		Sex = sex;
	}
	public User() {
		super();
	}
	
	
}
