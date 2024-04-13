package com.jsp.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pan 
{
	@Id
	private int panId;
	private String panName;
	private String panLoction;
	public int getPanId() {
		return panId;
	}
	public void setPanId(int panId) {
		this.panId = panId;
	}
	public String getPanName() {
		return panName;
	}
	public void setPanName(String panName) {
		this.panName = panName;
	}
	public String getPanLoction() {
		return panLoction;
	}
	public void setPanLoction(String panLoction) {
		this.panLoction = panLoction;
	}
	@Override
	public String toString() {
		return "Pan [panId=" + panId + ", panName=" + panName + ", panLoction=" + panLoction + "]";
	}
	
	
}
