package com.recargapay.transaction_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.recargapay.transaction_service.model.Deposit;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.service.DepositService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deposits")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping
    public ResponseEntity<?> makeDeposit(@RequestBody Deposit deposit) {
        Deposit savedDeposit = depositService.createDeposit(deposit);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeposit);
    }
}