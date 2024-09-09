package com.recargapay.wallet_service.feign;

import org.springframework.beans.factory.annotation.Autowired;
import com.recargapay.wallet_service.feign.interfaces.UserServiceClientInterface;
import com.recargapay.wallet_service.model.User;

public class UserServiceClient {

	@Autowired
	private UserServiceClient userServiceClient;

	public User getUser(Long userId) {
		return userServiceClient.getUserById(userId);
	}
}