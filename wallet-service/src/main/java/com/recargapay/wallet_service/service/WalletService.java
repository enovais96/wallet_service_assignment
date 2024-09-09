package com.recargapay.wallet_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recargapay.wallet_service.model.Wallet;
import com.recargapay.wallet_service.model.ErrorResponse;
import com.recargapay.wallet_service.repository.WalletRepository;
import com.recargapay.wallet_service.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Optional<Wallet> getWalletById(Long idWallet) {
        return walletRepository.findById(idWallet);
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Optional<Wallet> getWalletByName(String name) {
        return walletRepository.findByNameWallet(name);
    }

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}