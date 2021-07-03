package com.digital.wallet.services;


import com.digital.wallet.modelRequests.TransferMoneyRequest;
import org.springframework.http.ResponseEntity;


public interface WalletService {
	
	ResponseEntity<?> findWalletTransactions(long walletId, String email);
	//ResponseEntity<String> topUpMoney(long walletId, CardInfo cardInfo, float amount, String email);
	ResponseEntity<String> topUpMoney(long walletId, int pin, float amount, String email);
	ResponseEntity<String> transferAmount(long walletId, TransferMoneyRequest transfer, String name);
	

}
