package com.v2vCouriers.myapp.jwtauthentication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "repprice")
public class RepPrice{

	@Id
	private Long courier_id = 0L;
	
	@Column
	private Long price_id = 0L;
	
	@Column
	private String price = "0";

	public RepPrice() {}
	
	public RepPrice(Long courier_id, Long price_id, String price) {
		super();
		this.courier_id = courier_id;
		this.price_id = price_id;
		this.price = price;
	}

	public Long getCourier_id() {
		return courier_id;
	}

	public void setCourier_id(Long courier_id) {
		this.courier_id = courier_id;
	}

	public Long getPrice_id() {
		return price_id;
	}

	public void setPrice_id(Long price_id) {
		this.price_id = price_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}
