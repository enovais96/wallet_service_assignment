package com.recargapay.transaction_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.recargapay.transaction_service.model.Withdraw;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.service.WithdrawService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/withdraws")
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;

    @PostMapping
    public ResponseEntity<?> makeWithdraw(@RequestBody Withdraw withdraw) {
        Withdraw savedWithdraw = withdrawService.createWithdraw(withdraw);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWithdraw);
    }
}