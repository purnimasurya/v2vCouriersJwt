package com.v2vCouriers.myapp.jwtauthentication.message.request;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.sun.istack.internal.NotNull;

public class CourierForm {

	private Long id;
	
    @NotBlank
    @Size(min=3, max = 50)
    private String senderName;
    
    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @Size(min=10, max = 11)
    private String phNumber;
    
    @NotBlank
    @Size(min=3, max = 90)
    private String senderAddress;
    
    @NotBlank
    @Size(min=3, max = 30)
    private String senderCity;
    
    @NotBlank
    @Size(min=3, max = 30)
    private String senderState;
    
    @NotNull
    private boolean agree;

    @NotBlank
    @Size(min=3, max = 50)
    private String contactType;
    
    @NotBlank
    @Size(min=3, max = 50)
    private String repName;
    
    @NotBlank
    @Size(min=10, max = 11)
    private String repPhNumber;
    
    @NotBlank
    @Size(min=3, max = 90)
    private String repAddress;
    
    @NotBlank
    @Size(min=3, max = 30)
    private String repCity;
    
    @NotBlank
    @Size(min=3, max = 30)
    private String repState;
    
    @NotBlank
    @Size(min=3, max = 50)
    private String courierService;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date pickupDate;
    
    
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
