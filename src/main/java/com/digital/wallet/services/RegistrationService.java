package com.digital.wallet.services;


import com.digital.wallet.modelRequests.RegisterRequest;
import org.springframework.http.ResponseEntity;


public interface RegistrationService {
	
	public ResponseEntity<String> register(RegisterRequest req);
}
