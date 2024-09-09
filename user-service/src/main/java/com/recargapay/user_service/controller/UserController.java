package com.recargapay.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.recargapay.user_service.model.User;
import com.recargapay.user_service.model.ErrorResponse;
import com.recargapay.user_service.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{idUser}")
    public ResponseEntity<?> getUser(@PathVariable Long idUser) {
        Optional<User> user = userService.getUserById(idUser);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            ErrorResponse errorResponse = new ErrorResponse("User not found for this idUser :: " + idUser);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (userService.getUserByName(user.getNameUser()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("A user with the same name already exists.");
        }
        User savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}