package com.v2vCouriers.myapp.jwtauthentication.model;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.repository.Modifying;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "courier")
@DynamicUpdate
public class Courier {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    @Column
    private String senderName;
    
    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    @Column
    private String email;
    
    @NotBlank
    @Size(min=10, max = 11)
    @Column
    private String phNumber;
    
    @NotBlank
    @Size(min=3, max = 90)
    @Column
    private String senderAddress;
    
    @NotBlank
    @Size(min=3, max = 30)
    @Column
    private String senderCity;
    
    @NotBlank
    @Size(min=3, max = 30)
    @Column
    private String senderState;
    
    @NotNull
    @Column
    private boolean agree;

    @NotBlank
    @Size(min=3, max = 50)
    @Column
    private String contactType;
    
    @NotBlank
    @Size(min=3, max = 50)
    @Column
    private String repName;
    
    @NotBlank
    @Size(min=10, max = 11)
    @Column
    private String repPhNumber;
    
    @NotBlank
    @Size(min=3, max = 90)
    @Column
    private String repAddress;
    
    @NotBlank
    @Size(min=3, max = 30)
    @Column
    private String repCity;
    
    @NotBlank
    @Size(min=3, max = 30)
    @Column
    private String repState;
    
    @NotBlank
    @Size(min=3, max = 50)
    @Column
    private String courierService;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column
    private Date pickupDate;
    
    @Size(min=3, max = 90)
   // @Column(columnDefinition = "varchar(30) default 'Yet to accept'")
    @Column
    private String status = "Yet_to_accept";
    
    @NotBlank
    @Column
    private String wt;
    
    @NotBlank
    @Column
    private String vol;
    
    @Column
    private String price;

	public Courier(String senderName, String email, String phNumber,String senderAddress, String senderState, String senderCity,
			boolean agree, String contactType,String repName,String repPhNumber,String repAddress, String repCity,
			String repState,String courierService, Date pickupDate,String wt, String vol, String price) {
		super();
		this.senderName = senderName;
		this.email = email;
		this.phNumber = phNumber;
		this.senderAddress = senderAddress;
		this.senderCity = senderCity;
		this.senderState = senderState;
		this.agree = agree;
		this.contactType = contactType;
		this.repName = repName;
		this.repPhNumber = repPhNumber;
		this.repAddress = repAddress;
		this.repCity = repCity;
		this.repState = repState;
		this.courierService = courierService;
		this.pickupDate = pickupDate;
		this.wt = wt;
		this.vol = vol;
		this.price = price;
	}

	
	public Courier() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhNumber() {
		return phNumber;
	}


	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}


	public String getSenderAddress() {
		return senderAddress;
	}


	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}


	public String getSenderCity() {
		return senderCity;
	}


	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}


	public String getSenderState() {
		return senderState;
	}


	public void setSenderState(String senderState) {
		this.senderState = senderState;
	}


	public boolean isAgree() {
		return agree;
	}


	public void setAgree(boolean agree) {
		this.agree = agree;
	}


	public String getContactType() {
		return contactType;
	}


	public void setContactType(String contactType) {
		this.contactType = contactType;
	}


	public String getRepName() {
		return repName;
	}


	public void setRepName(String repName) {
		this.repName = repName;
	}


	public String getRepPhNumber() {
		return repPhNumber;
	}


	public void setRepPhNumber(String repPhNumber) {
		this.repPhNumber = repPhNumber;
	}


	public String getRepAddress() {
		return repAddress;
	}


	public void setRepAddress(String repAddress) {
		this.repAddress = repAddress;
	}


	public String getRepCity() {
		return repCity;
	}


	public void setRepCity(String repCity) {
		this.repCity = repCity;
	}


	public String getRepState() {
		return repState;
	}


	public void setRepState(String repState) {
		this.repState = repState;
	}


	public String getCourierService() {
		return courierService;
	}


	public void setCourierService(String courierService) {
		this.courierService = courierService;
	}


	public Date getPickupDate() {
		return pickupDate;
	}


	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getWt() {
		return wt;
	}


	public void setWt(String wt) {
		this.wt = wt;
	}


	public String getVol() {
		return vol;
	}


	public void setVol(String vol) {
		this.vol = vol;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
  
    
}
