package com.recargapay.wallet_service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.recargapay.wallet_service.json.UserJson;
import com.recargapay.wallet_service.exception.UserNotFoundException;

@Component
public class UserServiceRest {

	@Autowired
	private RestTemplate restTemplate;

	public UserJson getUserById(Long userId) {
		String url = "http://user-service:8080/users/" + userId;
		ResponseEntity<UserJson> response = restTemplate.getForEntity(url, UserJson.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		} else {
			throw new UserNotFoundException("User with ID " + userId + " not found.");
		}
	}
}