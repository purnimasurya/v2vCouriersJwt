package com.v2vCouriers.myapp.jwtauthentication.model;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;


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
    private String sendername;
    
    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    @Column
    private String email;
    
    @NotBlank
    @Size(min=10, max = 11)
    @Column
    private String phnumber;
    
    @NotBlank
    @Size(min=3, max = 90)
    @Column
    private String senderaddress;
    
    @NotBlank
    @Size(min=3, max = 30)
    @Column
    private String sendercity;
    
    @NotBlank
    @Size(min=3, max = 30)
    @Column
    private String senderstate;
    
    @Column
    private boolean agree;

    @NotBlank
    @Size(min=3, max = 50)
    @Column
    private String contacttype;
    
    @NotBlank
    @Size(min=3, max = 50)
    @Column
    private String repName;
    
    @NotBlank
    @Size(min=10, max = 11)
    @Column
    private String repphnumber;
    
    @NotBlank
    @Size(min=3, max = 90)
    @Column
    private String repaddress;
    
    @NotBlank
    @Size(min=3, max = 30)
    @Column
    private String repcity;
    
    @NotBlank
    @Size(min=3, max = 30)
    @Column
    private String repstate;
    
    @NotBlank
    @Size(min=3, max = 50)
    @Column
    private String courierservice;
    
    @Temporal(TemporalType.DATE)
    @Column
    private Date pickupdate;
    
    @Size(min=3, max = 90)
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
		this.sendername = senderName;
		this.email = email;
		this.phnumber = phNumber;
		this.senderaddress = senderAddress;
		this.sendercity = senderCity;
		this.senderstate = senderState;
		this.agree = agree;
		this.contacttype = contactType;
		this.repName = repName;
		this.repphnumber = repPhNumber;
		this.repaddress = repAddress;
		this.repcity = repCity;
		this.repstate = repState;
		this.courierservice = courierService;
		this.pickupdate = pickupDate;
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
		return sendername;
	}


	public void setSenderName(String senderName) {
		this.sendername = senderName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhNumber() {
		return phnumber;
	}


	public void setPhNumber(String phNumber) {
		this.phnumber = phNumber;
	}


	public String getSenderAddress() {
		return senderaddress;
	}


	public void setSenderAddress(String senderAddress) {
		this.senderaddress = senderAddress;
	}


	public String getSenderCity() {
		return sendercity;
	}


	public void setSenderCity(String senderCity) {
		this.sendercity = senderCity;
	}


	public String getSenderState() {
		return senderstate;
	}


	public void setSenderState(String senderState) {
		this.senderstate = senderState;
	}


	public boolean isAgree() {
		return agree;
	}


	public void setAgree(boolean agree) {
		this.agree = agree;
	}


	public String getContactType() {
		return contacttype;
	}


	public void setContactType(String contactType) {
		this.contacttype = contactType;
	}


	public String getRepName() {
		return repName;
	}


	public void setRepName(String repName) {
		this.repName = repName;
	}


	public String getRepPhNumber() {
		return repphnumber;
	}


	public void setRepPhNumber(String repPhNumber) {
		this.repphnumber = repPhNumber;
	}


	public String getRepAddress() {
		return repaddress;
	}


	public void setRepAddress(String repAddress) {
		this.repaddress = repAddress;
	}


	public String getRepCity() {
		return repcity;
	}


	public void setRepCity(String repCity) {
		this.repcity = repCity;
	}


	public String getRepState() {
		return repstate;
	}


	public void setRepState(String repState) {
		this.repstate = repState;
	}


	public String getCourierService() {
		return courierservice;
	}


	public void setCourierService(String courierService) {
		this.courierservice = courierService;
	}


	public Date getPickupDate() {
		return pickupdate;
	}


	public void setPickupDate(Date pickupDate) {
		this.pickupdate = pickupDate;
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
