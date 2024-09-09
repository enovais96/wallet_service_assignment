package com.recargapay.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recargapay.user_service.model.User;
import com.recargapay.user_service.model.ErrorResponse;
import com.recargapay.user_service.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long idUser) {
        return userRepository.findById(idUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByNameUser(name);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}