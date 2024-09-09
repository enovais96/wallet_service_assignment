package com.recargapay.wallet_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recargapay.wallet_service.model.Wallet;
import com.recargapay.wallet_service.model.ErrorResponse;
import com.recargapay.wallet_service.model.User;
import com.recargapay.wallet_service.repository.WalletRepository;
import com.recargapay.wallet_service.rest.UserServiceRest;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserServiceRest userServiceRest;

    public Optional<Wallet> getWalletById(Long idWallet) {
        return walletRepository.findById(idWallet);
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Wallet createWallet(Wallet wallet) {
        User user;
        try {
            user = userServiceRest.getUserById(wallet.getIdUser());
        } catch (Exception e) {
            // Retorne uma resposta padrão ou um objeto de erro
            throw new RuntimeException("Failed to get user from user service");
        }

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        wallet.setNameUser(user.getNameUser());
        return walletRepository.save(wallet);
    }

}