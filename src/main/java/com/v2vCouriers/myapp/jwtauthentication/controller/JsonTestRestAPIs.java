package com.v2vCouriers.myapp.jwtauthentication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.v2vCouriers.myapp.jwtauthentication.model.CourierData;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v2vcouriers")
public class JsonTestRestAPIs {
	
	//Sample request
	//https://localhost:8443/v2vcouriers/jsontest/{id}
	@GetMapping("/jsontest/{id}")
	public CourierData getPostById(@PathVariable Long id) throws Exception {

	    final String uri = "http://localhost:3000/couriers/" + Long.toString(id);
	    RestTemplate restTemplate = new RestTemplate();
		CourierData resp = restTemplate.getForObject(uri, CourierData.class);
		
		List<String> locations = resp.getLocations();
		
		int counter = resp.getCounter();
		
		if(counter < locations.size()) {
			resp.setCurrentLocation(locations.get(counter));
		}
	    
		
	    return resp;
	   
	}
}
