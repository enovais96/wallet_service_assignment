package com.recargapay.transaction_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.recargapay.transaction_service.model.Wallet;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.service.WalletService;
import com.recargapay.transaction_service.service.BalanceService;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/balances")
public class BalanceController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private BalanceService balanceService;

    @GetMapping("/{idWallet}")
    public ResponseEntity<?> getBalance(@PathVariable Long idWallet) {
        Wallet wallet = walletService.getWalletById(idWallet);
        if (wallet != null) {
            return ResponseEntity.ok(wallet.getValueAvaiable());
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Wallet not found for this idWallet :: " + idWallet);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/{idWallet}/{dateBalance}")
    public ResponseEntity<?> getBalanceByDate(@PathVariable Long idWallet, @PathVariable String dateBalance) {
        Double wallet = balanceService.getWalletByIdByDate(idWallet, dateBalance);
        if (wallet != null) {
            return ResponseEntity.ok(wallet);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Wallet not found for this idWallet :: " + idWallet);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}