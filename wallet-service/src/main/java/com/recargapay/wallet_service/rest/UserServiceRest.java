package com.recargapay.wallet_service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.recargapay.wallet_service.model.User;
import com.recargapay.wallet_service.exception.UserNotFoundException;

@Component
public class UserServiceRest {

	@Autowired
	private RestTemplate restTemplate;

	public User getUserById(Long userId) {
		String url = "http://user-service:8080/users/" + userId;
		ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		} else {
			throw new UserNotFoundException("User with ID " + userId + " not found.");
		}
	}
}