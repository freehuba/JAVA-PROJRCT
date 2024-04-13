package com.jsp.hibernate.MyFirstProj1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item 
{
	@Id
	private int iId;
	private String iName;
	private int iPrice;
	
	@ManyToMany(mappedBy = "ilist")
	private List<Cart> clist = new ArrayList<Cart>();
	
	public List<Cart> getClist() {
		return clist;
	}
	public void setClist(List<Cart> clist) {
		this.clist = clist;
	}
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public int getiPrice() {
		return iPrice;
	}
	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}
	@Override
	public String toString() {
		return "Item [iId=" + iId + ", iName=" + iName + ", iPrice=" + iPrice + "]";
	}
	
	
}
