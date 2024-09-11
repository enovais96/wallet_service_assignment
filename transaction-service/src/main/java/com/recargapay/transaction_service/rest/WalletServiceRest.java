package com.recargapay.transaction_service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.recargapay.transaction_service.json.WalletJson;
import com.recargapay.transaction_service.exception.WalletNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WalletServiceRest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private final ObjectMapper objectMapper = new ObjectMapper();

	public WalletJson getWalletById(Long walletId) {
		String url = "http://wallet-service:8080/wallets/" + walletId;
		ResponseEntity<WalletJson> response = restTemplate.getForEntity(url, WalletJson.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			System.out.println(response.getBody());
			return response.getBody();
		} else {
			throw new WalletNotFoundException("User with ID " + walletId + " not found.");
		}
	}

}