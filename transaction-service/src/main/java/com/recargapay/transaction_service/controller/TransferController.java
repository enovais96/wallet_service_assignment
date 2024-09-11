package com.recargapay.transaction_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.recargapay.transaction_service.model.Transfer;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.service.TransferService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<?> makeTransfer(@RequestBody Transfer transfer) {
        Transfer savedTransfer = transferService.createTransfer(transfer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransfer);
    }
}