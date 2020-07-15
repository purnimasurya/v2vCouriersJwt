package com.v2vCouriers.myapp.jwtauthentication.controller;




import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.v2vCouriers.myapp.jwtauthentication.message.request.CourierForm;
import com.v2vCouriers.myapp.jwtauthentication.message.response.ResponseMessage;
import com.v2vCouriers.myapp.jwtauthentication.model.Courier;
import com.v2vCouriers.myapp.jwtauthentication.model.Price;
import com.v2vCouriers.myapp.jwtauthentication.model.RepPrice;
import com.v2vCouriers.myapp.jwtauthentication.model.SenderPrice;
import com.v2vCouriers.myapp.jwtauthentication.model.Vehicle;
import com.v2vCouriers.myapp.jwtauthentication.model.VehicleName;
import com.v2vCouriers.myapp.jwtauthentication.repository.CourierRepository;
import com.v2vCouriers.myapp.jwtauthentication.repository.RepPriceRepository;
import com.v2vCouriers.myapp.jwtauthentication.repository.SenderPriceRepository;
import com.v2vCouriers.myapp.jwtauthentication.repository.VehicleRepository;
import com.v2vCouriers.myapp.jwtauthentication.security.services.CourierDetailsService;
import com.v2vCouriers.myapp.jwtauthentication.security.services.PriceDetailsService;
import com.v2vCouriers.myapp.jwtauthentication.security.services.RepPriceDetailsService;
import com.v2vCouriers.myapp.jwtauthentication.security.services.SenderPriceDetailsService;





@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v2vcouriers")
public class CourierRestAPIs {

	@Autowired
	CourierRepository courierRepository;
	
	@Autowired
	private CourierDetailsService courierDetailsService;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	PriceDetailsService priceDetailsService;
	
	@Autowired
	SenderPriceDetailsService senderPriceDetailsService;
	
	@Autowired
	RepPriceDetailsService repPriceDetailsService;
	
	@Autowired
	SenderPriceRepository senderPriceRepository;
	
	@Autowired
	RepPriceRepository repPriceRepository;

	
	//http://localhost:8080/v2vcouriers/newcourier
	@PostMapping("/newcourier")
	public ResponseEntity<?> saveCourier (@Valid @RequestBody CourierForm courierRequest) throws Exception {

		// Saving the new Courier Details
		Courier courier = new Courier(courierRequest.getSendername(), courierRequest.getEmail(), courierRequest.getPhnumber(), 
				courierRequest.getSenderaddress(), courierRequest.getSendercity(), courierRequest.getSenderdistrict(), courierRequest.getSenderstate(),
				courierRequest.getSendercountry(), courierRequest.isAgree(), courierRequest.getContacttype(), courierRequest.getRepname(), 
				courierRequest.getRepphnumber(), courierRequest.getRepaddress(), courierRequest.getRepcity(), courierRequest.getRepdistrict(),
				courierRequest.getRepstate(), courierRequest.getRepcountry(), courierRequest.getCourierservice(), courierRequest.getPickupdate(), 
				courierRequest.getStatus(), courierRequest.getWt(), courierRequest.getVol(), courierRequest.getPrice());
		
		Vehicle strVehicle;
		Set<Vehicle> vehicle = new HashSet<>();
		
		switch (courierRequest.getCourierservice().toLowerCase()) {
			case "standard":
				strVehicle = vehicleRepository.findByName(VehicleName.VEHICLE_TRUCK)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: Courier Vehicle not found."));
				vehicle.add(strVehicle);

				break;
			case "pallet":
				strVehicle = vehicleRepository.findByName(VehicleName.VEHICLE_TRUCK)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: Courier Vehicle not found."));
				vehicle.add(strVehicle);

				break;
			case "same-day":
				strVehicle = vehicleRepository.findByName(VehicleName.VEHICLE_TRAIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: Courier Vehicle not found."));
				vehicle.add(strVehicle);

				break;
			case "overnight":
				strVehicle = vehicleRepository.findByName(VehicleName.VEHICLE_AIRPLANE)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: Courier Vehicle not found."));
				vehicle.add(strVehicle);

				break;
			case "international":
				strVehicle = vehicleRepository.findByName(VehicleName.VEHICLE_AIRPLANE)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: Courier Vehicle not found."));
				vehicle.add(strVehicle);
		}
		
		courier.setVehicle(vehicle);

		courierRepository.save(courier);
		
		savePrice(courier);
		
		return new ResponseEntity<>(new ResponseMessage("Courier registered successfully!"), HttpStatus.OK);
		
	}
	
	@GetMapping("/newPrice")
 	public ResponseEntity<?> savePrice(Courier courier) throws Exception {
 		Long id1 = null;
 		String price1 = null;
 		Long id2 = null;
 		String price11 = null;
 		Long id = courier.getId();


 		String sendercity = new String(courier.getSendercity());
 		String senderdistrict = new String(courier.getSenderdistrict());
 		int c_price = Integer.parseInt(courier.getPrice());
 		
 		Set<Vehicle> vehicle = courier.getVehicle();
 		Long vehicle_id = null;
 		
 		for (Vehicle temp : vehicle) {
 	        vehicle_id = temp.getId();
 	     }

 		List<Price> price = priceDetailsService.findByCity(sendercity);
 		for(Price p : price) {
 			String a = p.getDistrict();
 			if(a.equals(senderdistrict)) {
 				id1 = p.getId();

 				price1 = p.getPrice();
 			}
 		}

 		String repcity = new String(courier.getRepcity());
 		String repdistrict = new String(courier.getRepdistrict());

 		List<Price> price2 = priceDetailsService.findByCity(repcity);
 		for(Price p : price2) {
 			String a = p.getDistrict();
 			if(a.equals(repdistrict)) {
 				id2 = p.getId();

 				price11 = p.getPrice();
 			}
 		}

 		SenderPrice senderPrice = new SenderPrice(id, id1, price1);
 		senderPrice.setVehicleid(vehicle_id);
 		senderPriceRepository.save(senderPrice);

 		RepPrice repPrice = new RepPrice(id, id2, price11);
 		repPrice.setVehicleid(vehicle_id);
 		repPriceRepository.save(repPrice);

 		String tot_price = Integer.toString(Integer.parseInt(price1) + Integer.parseInt(price11) + c_price);
 		courier.setPrice(tot_price);
 		courierRepository.save(courier);
 		return new ResponseEntity<>(new ResponseMessage("Courier price updated successfully!"), HttpStatus.OK);	

 	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/couriers
	@RequestMapping("/couriers")
	public List<Courier> getCourierById() throws Exception {
		return courierDetailsService.findAll();
	}


	//Sample request
	//http://localhost:8080/v2vcouriers/courierbyid/{id}
	@RequestMapping("/courierbyid/{id}")
	public Courier getCourierById(@PathVariable Long id) throws Exception {
		return courierDetailsService.findById(id);
	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/courierbyemail?email=abc@gmail.com
	@RequestMapping("/courierbyemail")
	public Courier getCourierByEmail(@RequestParam("email")  String email) throws Exception {
		return courierDetailsService.findByEmail(email);
	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/couriersbyytastatus
	@RequestMapping("/couriersbyytastatus")
	public List<Courier> getCourierByYtaStatus() throws Exception {
		return courierDetailsService.findByStatus("Yet_to_accept");
	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/couriersbyytrstatus
	@RequestMapping("/couriersbyytrstatus")
	public List<Courier> getCourierByYtrStatus() throws Exception {
		return courierDetailsService.findByStatus("Yet_to_recieve");
	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/couriersbyinstatus
	@RequestMapping("/couriersbyinstatus")
	public List<Courier> getCourierByInStatus() throws Exception {
		return courierDetailsService.findByStatus("In_progress");
	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/couriersbyrtdstatus
	@RequestMapping("/couriersbyrtdstatus")
	public List<Courier> getCourierByRtdStatus() throws Exception {
		return courierDetailsService.findByStatus("Ready_to_deliever");
	}
	
	//Sample request
	//http://localhost:8080/v2vcouriers/updateytastatus
	@PutMapping("/updateytastatus/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateYetToAcceptStatus (@PathVariable Long id) {

		// Updating the Courier Status
		try {
			courierDetailsService.updateStatusToYetToRecieve(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ResponseMessage("Courier status updated successfully!"), HttpStatus.OK);
		
	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/updateytastatus
	@PutMapping("/updateytrstatus/{id}")
	@PreAuthorize("hasRole('COURIERBOY')")
	public ResponseEntity<?> updateYetToRecieveStatus (@PathVariable Long id) {

		// Updating the Courier Status
		try {
			courierDetailsService.updateStatusToInProgress(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		return new ResponseEntity<>(new ResponseMessage("Courier status updated successfully!"), HttpStatus.OK);
			
	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/updateinstatus
	@PutMapping("/updateipstatus/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateInProgressStatus (@PathVariable Long id) {

		// Updating the Courier Status
		try 
		{
			courierDetailsService.updateStatusToReadyToDeliver(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		return new ResponseEntity<>(new ResponseMessage("Courier status updated successfully!"), HttpStatus.OK);
			
	}
	
	
	//Sample request
	//http://localhost:8080/v2vcouriers/updatertdstatus
	@PutMapping("/updatertdstatus/{id}")
	@PreAuthorize("hasRole('COURIERBOY')")
	public ResponseEntity<?> updateReadyToDeliverStatus (@PathVariable Long id) {

		// Updating the Courier Status
		try {
			courierDetailsService.updateStatusToDelivered(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		return new ResponseEntity<>(new ResponseMessage("Courier status updated successfully!"), HttpStatus.OK);
			
	}
	
	//Sample request
	//http://localhost:8080/v2vcouriers/courierbyvehicle/{id}
	@RequestMapping("/courierbyvehicle/{id}")
	public List<Courier> getCourierByVehicle(@PathVariable Long id) throws Exception {
		return courierDetailsService.findByVehicle_Id(id);
	}
	
	@GetMapping("/sendervehicleidbycourierid/{id}")
	public Long getSenderVehicleIdByCourierId(@PathVariable Long id) throws Exception {
		return senderPriceDetailsService.findByCourierid(id);
	}
	
	@GetMapping("/repvehicleidbycourierid/{id}")
	public Long getRepVehicleIdByCourierId(@PathVariable Long id) throws Exception {
		return repPriceDetailsService.findByCourierid(id);
	}
	
	@RequestMapping("/senderbyid/{id}")
	public Optional<SenderPrice> getSenderPriceById(@PathVariable Long id) throws Exception {
		return senderPriceDetailsService.findById(id);
	}
	
	
}
