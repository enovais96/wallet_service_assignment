package com.recargapay.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.recargapay.user_service.model.User;
import com.recargapay.user_service.model.ErrorResponse;
import com.recargapay.user_service.repository.UserRepository;
import com.recargapay.user_service.exception.ResourceNotFoundException;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{idUser}")
    public ResponseEntity<?> getUser(@PathVariable Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            ErrorResponse errorResponse = new ErrorResponse("User not found for this idUser :: " + idUser);
            return ResponseEntity.ok(errorResponse);
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?>  createUser(@RequestBody User user) {
        if (userRepository.findByNameUser(user.getNameUser()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("A user with the same name already exists.");
        }
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<?> updateUser(@PathVariable Long idUser, @RequestBody User userDetails) {
        Optional<User> user = userRepository.findById(idUser);
        if (user.isPresent()) {
            user.get().setNameUser(userDetails.getNameUser());
            final User updatedUser = userRepository.save(user.get());
            return ResponseEntity.ok(updatedUser);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("User not found for this idUser :: " + idUser);
            return ResponseEntity.ok(errorResponse);
        }
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<?> deleteUser(@PathVariable Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);

            return ResponseEntity.ok(response);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("User not found for this idUser :: " + idUser);
            return ResponseEntity.ok(errorResponse);
        }
    }
}