package com.jsp.criteria;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage =  CacheConcurrencyStrategy.READ_ONLY)
public class Consumer 
{
	@Id
	private int consumerId;
	private String consumerName;
	private String consumerContact;
	
	@OneToOne(mappedBy = "consum")
	private Product pro;
	
	
	
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getConsumerContact() {
		return consumerContact;
	}
	public void setConsumerContact(String consumerContact) {
		this.consumerContact = consumerContact;
	}
	@Override
	public String toString() {
		return "Consumer [consumerId=" + consumerId + ", consumerName=" + consumerName + ", consumerContact="
				+ consumerContact + "]";
	}
	
	
	
}
