package com.v2vCouriers.myapp.jwtauthentication.message.request;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

public class CourierForm {

	private Long id;
	
    @NotBlank
    @Size(min=3, max = 50)
    private String sendername;
    
    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @Size(min=10, max = 11)
    private String phnumber;
    
    @NotBlank
    @Size(min=3, max = 90)
    private String senderaddress;
    
    @NotBlank
    @Size(min=3, max = 30)
    private String sendercity;
    
    @NotBlank
    @Size(min=3, max = 30)
    private String senderstate;
    
    private boolean agree;

    @NotBlank
    @Size(min=3, max = 50)
    private String contacttype;
    
    @NotBlank
    @Size(min=3, max = 50)
    private String repname;
    
    @NotBlank
    @Size(min=10, max = 11)
    private String repphnumber;
    
    @NotBlank
    @Size(min=3, max = 90)
    private String repaddress;
    
    @NotBlank
    @Size(min=3, max = 30)
    private String repcity;
    
    @NotBlank
    @Size(min=3, max = 30)
    private String repstate;
    
    @NotBlank
    @Size(min=3, max = 50)
    private String courierservice;
    
    @Temporal(TemporalType.DATE)
    private Date pickupdate;
    
    
    @Size(min=3, max = 90)
    private String status = "Yet_to_accept";
    
    @NotBlank
    private String wt;
    
    @NotBlank
    private String vol;
    
    private String price;

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
		return repname;
	}

	public void setRepName(String repName) {
		this.repname = repName;
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
