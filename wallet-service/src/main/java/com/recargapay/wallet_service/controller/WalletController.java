package com.recargapay.wallet_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.recargapay.wallet_service.model.Wallet;
import com.recargapay.wallet_service.model.ErrorResponse;
import com.recargapay.wallet_service.service.WalletService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/{idWallet}")
    public ResponseEntity<?> getWallet(@PathVariable Long idWallet) {
        Optional<Wallet> wallet = walletService.getWalletById(idWallet);
        if (wallet.isPresent()) {
            return ResponseEntity.ok(wallet.get());
        } else {
            ErrorResponse errorResponse = new ErrorResponse("Wallet not found for this idWallet :: " + idWallet);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @PostMapping
    public ResponseEntity<?> createWallet(@RequestBody Wallet wallet) {
        Wallet savedWallet = walletService.createWallet(wallet);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWallet);
    }
}