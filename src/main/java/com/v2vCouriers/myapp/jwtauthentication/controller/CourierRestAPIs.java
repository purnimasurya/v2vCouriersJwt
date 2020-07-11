package com.v2vCouriers.myapp.jwtauthentication.controller;




import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.v2vCouriers.myapp.jwtauthentication.model.Vehicle;
import com.v2vCouriers.myapp.jwtauthentication.model.VehicleName;
import com.v2vCouriers.myapp.jwtauthentication.repository.CourierRepository;
import com.v2vCouriers.myapp.jwtauthentication.repository.VehicleRepository;
import com.v2vCouriers.myapp.jwtauthentication.security.services.CourierDetailsService;





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

	
	//http://localhost:8080/v2vcouriers/newcourier
	@PostMapping("/newcourier")
	public ResponseEntity<?> saveCourier (@Valid @RequestBody CourierForm courierRequest) {

		// Saving the new Courier Details
		Courier courier = new Courier(courierRequest.getSendername(), courierRequest.getEmail(), courierRequest.getPhnumber(), 
				courierRequest.getSenderaddress(), courierRequest.getSendercity(), courierRequest.getSenderstate(),
				courierRequest.getSendercountry(), courierRequest.isAgree(), courierRequest.getContacttype(), courierRequest.getRepname(), 
				courierRequest.getRepphnumber(), courierRequest.getRepaddress(), courierRequest.getRepcity(),
				courierRequest.getSenderstate(), courierRequest.getRepcountry(), courierRequest.getCourierservice(), courierRequest.getPickupdate(), 
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

		/*Vehicle trainVehicle = vehicleRepository.findByName(VehicleName.VEHICLE_TRAIN)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));*/
		
		courier.setVehicle(vehicle);

		courierRepository.save(courier);

		return new ResponseEntity<>(new ResponseMessage("Courier registered successfully!"), HttpStatus.OK);
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
	
}
