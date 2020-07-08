package com.v2vCouriers.myapp.jwtauthentication.security.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.v2vCouriers.myapp.jwtauthentication.model.Courier;
import com.v2vCouriers.myapp.jwtauthentication.repository.CourierRepository;

@Service
public class CourierDetailsService {

	 	@Autowired
	    private CourierRepository courierRepository;

	    public Courier findById(Long id) {
	    	
	        Courier courier = null;
			try {
				courier = courierRepository.findById(id).orElseThrow(
						() -> new Exception("Courier Not Found with -> id : " + id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return courier;
	    }
	    
	    public Courier findByEmail(String email) {
	    	
	        Courier courier = null;
			try {
				courier = courierRepository.findByEmail(email).orElseThrow(
						() -> new Exception("Courier Not Found with -> email : " + email));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return courier;
	    }
	    
	    public List<Courier> findByStatus(String status){
	    	
	        List<Courier>  courier= courierRepository.findByStatus(status);
	        return courier;
	        
	    }

		public void updateStatus(Long id) {
			
			Courier courier = null;
			try {
				courier = courierRepository.findById(id).orElseThrow(
						() -> new Exception("Courier Not Found with -> id : " + id));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String status = courier.getStatus();
			if(status.equals("Yet_to_accept")) {
				courier.setStatus("Yet_to_recieve");
			}
			if(status.equals("Yet_to_recieve")) {
				courier.setStatus("In_progress");
			}
			if(status.equals("In_progress")) {
				courier.setStatus("Ready_to_deliver");
			}
			if(status.equals("Ready_to_deliver")) {
				courier.setStatus("Delivered");
			}
			courierRepository.save(courier);
		}
}
