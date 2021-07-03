package com.digital.wallet.controllers;

import com.digital.wallet.modelRequests.TransferMoneyRequest;
import com.digital.wallet.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
//@CrossOrigin
@RequestMapping("/api/v1/wallet/")

public class WalletController {
	@Autowired
	private WalletService walletService;

	@PostMapping("{walletSenderId}/transfer")
	public ResponseEntity<String> transfer(@PathVariable("walletSenderId") long walletId, @RequestBody TransferMoneyRequest transfer, Principal p) {
		if (p == null)
			return error("JWT expired");
		if (transfer.getAmount() == 0)
			return error("invalide ammount "+0);
		return walletService.transferAmount(walletId, transfer, p.getName());
	}

	@GetMapping("{walletId}/transactions")
	public ResponseEntity<?> getTransactions(@PathVariable("walletId") long walletId, Principal p) {
		if (p == null)
			return error("JWT expired");
		return walletService.findWalletTransactions(walletId, p.getName());

	}

	// add card with amount here
	/*
	 * @PostMapping("topUp") public ResponseEntity<String>
	 * topUp(@PathVariable("walletId") long walletId,@RequestParam("amount") float
	 * amount,@RequestBody CardInfo card, Principal p){ if(p == null) return
	 * error("JWT expired"); if( amount == 0) return
	 * error("invalide amount : "+amount); return walletService.topUpMoney(walletId,
	 * card, amount,p.getName());
	 * 
	 * }
	 */

	@PostMapping("{walletId}/topUp")
	public ResponseEntity<String> topUp(@PathVariable("walletId") long walletId, @RequestParam("amount") float amount,@RequestParam("pin") int pin,
			Principal p) {
		if (p == null)
			return error("JWT expired");
		if (amount == 0)
			return error("invalide amount : " + amount);

		return walletService.topUpMoney(walletId, pin, amount, p.getName());

	}

	private ResponseEntity<String> error(String mesage) {
		return new ResponseEntity<>(mesage, HttpStatus.BAD_REQUEST);
	}

}
