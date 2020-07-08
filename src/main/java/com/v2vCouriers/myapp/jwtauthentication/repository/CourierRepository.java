package com.v2vCouriers.myapp.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2vCouriers.myapp.jwtauthentication.model.Courier;

public interface CourierRepository extends JpaRepository<Courier, Long> {

	Optional<Courier> findById(Long id);
	Optional<Courier> findByEmail(String email);
	Optional<Courier> findByStatus(String status);
   
    
}
