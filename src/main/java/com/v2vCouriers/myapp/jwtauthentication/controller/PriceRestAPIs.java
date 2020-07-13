package com.v2vCouriers.myapp.jwtauthentication.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.v2vCouriers.myapp.jwtauthentication.model.Courier;
import com.v2vCouriers.myapp.jwtauthentication.model.Price;
import com.v2vCouriers.myapp.jwtauthentication.model.RepPrice;
import com.v2vCouriers.myapp.jwtauthentication.model.SenderPrice;
import com.v2vCouriers.myapp.jwtauthentication.repository.CourierRepository;
import com.v2vCouriers.myapp.jwtauthentication.repository.RepPriceRepository;
import com.v2vCouriers.myapp.jwtauthentication.repository.SenderPriceRepository;
import com.v2vCouriers.myapp.jwtauthentication.repository.VehicleRepository;
import com.v2vCouriers.myapp.jwtauthentication.security.services.CourierDetailsService;
import com.v2vCouriers.myapp.jwtauthentication.security.services.PriceDetailsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v2vcouriers")

	
public class PriceRestAPIs {

	@Autowired
	CourierRepository courierRepository;
	
	@Autowired
	private CourierDetailsService courierDetailsService;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	private PriceDetailsService priceDetailsService;
	
	@Autowired
	SenderPriceRepository senderPriceRepository;
	
	@Autowired
	RepPriceRepository repPriceRepository;

	
	
	@GetMapping("/newPrice")
	public Price savePrice() throws Exception {
		
		return priceDetailsService.findByDistrict("adyar");
		
	}
	
	@GetMapping("/newPrice1")
	public List<Price> savePrice1() throws Exception {
		
		return priceDetailsService.findByCity("chennai");
		
	}
	
	@GetMapping("/newPrice2/{id}")
	public Price savePrice2(@PathVariable Long id) throws Exception {
		Long id1 = null;
		String price1 = null;
		Long id2 = null;
		String price11 = null;
		
		
		Courier courier = courierDetailsService.findById(id);
		String sendercity = new String(courier.getSendercity());
		String senderdistrict = new String(courier.getSenderdistrict());
		
		int c_price = Integer.parseInt(courier.getPrice());
		
		List<Price> price = priceDetailsService.findByCity(sendercity);
		for(Price p : price) {
			String a = p.getDistrict();
			System.out.println(a);
			if(a.equals(senderdistrict)) {
				id1 = p.getId();
				
				price1 = p.getPrice();
				//System.out.println("city:" + sendercity + " dis:" + senderdistrict + " p:" + price1 + " id:" + id1);
			}
		}
		
		String repcity = new String(courier.getRepcity());
		String repdistrict = new String(courier.getRepdistrict());
		
		List<Price> price2 = priceDetailsService.findByCity(repcity);
		for(Price p : price2) {
			String a = p.getDistrict();
			System.out.println(a);
			if(a.equals(repdistrict)) {
				id2 = p.getId();
				
				price11 = p.getPrice();
				//System.out.println("city:" + repcity + " dis:" + repdistrict + " p:" + price11 + " id:" + id2);
			}
		}
		
		SenderPrice senderPrice = new SenderPrice(id, id1, price1);
		senderPriceRepository.save(senderPrice);
		
		RepPrice repPrice = new RepPrice(id, id2, price11);
		repPriceRepository.save(repPrice);
		
		String tot_price = Integer.toString(Integer.parseInt(price1) + Integer.parseInt(price11) + c_price);
		courier.setPrice(tot_price);
		courierRepository.save(courier);
		return null;	
		
	}
	
	
	
	/*
	
	
	Price price = priceDetailsService.findByCityAndDistrict(sendercity,senderdistrict);
	//return price;
	
	Long id1 = price.getId();
	
	String price1 = price.getPrice();
	System.out.println("city:" + sendercity + " dis:" + senderdistrict + " p:" + price1 + " id:" + id1);
	
	
	SenderPrice senderPrice = new SenderPrice();
	senderPrice.setCourier_id(id);
	senderPrice.setPrice_id(id1);
	senderPrice.setPrice(price1);
	senderPriceRepository.save(senderPrice);
	
	
	String repcity = courier.getRepcity().toLowerCase();
	String repdistrict = courier.getRepdistrict().toLowerCase();
	
	Price price11 = priceDetailsService.findByCityAndDistrict(repcity,repdistrict);
	
	Long id2 = price11.getId();
	
	
	
	String price2 = price.getPrice();
	System.out.println("city:" + repcity + " dis:" + repdistrict + " p:" + price2 + " id:" + id2);
	
	
	
	RepPrice repPrice = new RepPrice();
	repPrice.setCourier_id(id);
	repPrice.setPrice_id(id2);
	repPrice.setPrice(price2);
	
	
	
	String tot_price = Integer.toString(Integer.parseInt(price1) + Integer.parseInt(price2));
	courier.setPrice(tot_price);
	courierRepository.save(courier);
	return new ResponseEntity<>(new ResponseMessage("Courier registered successfully!"), HttpStatus.OK);
	*/
}
