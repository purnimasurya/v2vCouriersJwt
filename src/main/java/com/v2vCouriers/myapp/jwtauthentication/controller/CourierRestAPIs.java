package com.v2vCouriers.myapp.jwtauthentication.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.v2vCouriers.myapp.jwtauthentication.message.request.CourierForm;
import com.v2vCouriers.myapp.jwtauthentication.message.response.ResponseMessage;
import com.v2vCouriers.myapp.jwtauthentication.model.Courier;
import com.v2vCouriers.myapp.jwtauthentication.repository.CourierRepository;
import com.v2vCouriers.myapp.jwtauthentication.security.services.CourierDetailsService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v2vcouriers")
public class CourierRestAPIs {

	@Autowired
	CourierRepository courierRepository;
	
	@Autowired
	private CourierDetailsService courierDetailsService;
	
	@PostMapping("/newcourier")
	public ResponseEntity<?> saveCourier (@Valid @RequestBody CourierForm courierRequest) {

		// Saving the new Courier Details
		Courier courier = new Courier(courierRequest.getSenderName(), courierRequest.getEmail(), courierRequest.getPhNumber(), 
				courierRequest.getSenderAddress(), courierRequest.getSenderCity(), courierRequest.getSenderState(), 
				courierRequest.isAgree(), courierRequest.getContactType(), courierRequest.getRepName(), 
				courierRequest.getRepPhNumber(), courierRequest.getRepAddress(), courierRequest.getRepCity(),
				courierRequest.getSenderState(), courierRequest.getCourierService(), courierRequest.getPickupDate(), 
				courierRequest.getWt(), courierRequest.getVol());

		courierRepository.save(courier);

		return new ResponseEntity<>(new ResponseMessage("Courier registered successfully!"), HttpStatus.OK);
	}
	
	
	@RequestMapping("/couriersbyid/{id}")
	public Courier getCourierById(@PathVariable Long id) {;
		return courierDetailsService.findById(id);
	}
	
	//http://localhost:8080/v2vcouriers/couriersbyemail?email=abc@gmail.com
	@RequestMapping("/couriersbyemail")
	public Courier getCourierByEmail(@RequestParam("email")  String email) {;
		return courierDetailsService.findByEmail(email);
	}
	
	@RequestMapping("/couriersbystatus")
	public List<Courier> getCourierByStatus(@RequestParam("status") String status) {;
		return courierDetailsService.findByStatus(status);
	}
	
	
}
