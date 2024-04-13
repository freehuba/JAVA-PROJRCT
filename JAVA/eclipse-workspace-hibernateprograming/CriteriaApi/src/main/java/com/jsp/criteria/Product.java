package com.jsp.criteria;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Product 
{
	@Id
	private int productId;
	private String productName;
	private int productQuntity;
	private Double productPrice;
	
	
	@OneToOne
	private Consumer consum;

	
	public Consumer getConsum() {
		return consum;
	}
	public void setConsum(Consumer consum) {
		this.consum = consum;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuntity() {
		return productQuntity;
	}
	public void setProductQuntity(int productQuntity) {
		this.productQuntity = productQuntity;
	}
	
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuntity=" + productQuntity
				+ ", productPrice=" + productPrice + "]";
	}
	
	
	
	
}
