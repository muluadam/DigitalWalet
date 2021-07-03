package com.digital.wallet.services;


import com.digital.wallet.models.ConfirmationToken;
import org.springframework.http.ResponseEntity;

public interface ConfirmationTokenService {
	
	public void save(ConfirmationToken token);
	public ResponseEntity<String> verifyToken(String token, int pin);
}
