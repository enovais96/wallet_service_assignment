package com.recargapay.transaction_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recargapay.transaction_service.model.Wallet;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.repository.WalletRepository;
import com.recargapay.transaction_service.rest.WalletServiceRest;
import com.recargapay.transaction_service.json.WalletJson;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private WalletServiceRest walletServiceRest;

    public Wallet getWalletById(Long idWallet) {
        Optional<Wallet> walletReturn = walletRepository.findById(idWallet);

        if(walletReturn.isPresent()) {
            return walletReturn.get();
        }

        try {
            WalletJson walletJson = walletServiceRest.getWalletById(idWallet);

            Wallet wallet = new Wallet();
            wallet.setIdWallet(walletJson.getIdWallet());
            wallet.setIdUser(walletJson.getIdUser());
            wallet.setNameUser(walletJson.getNameUser());

            return this.saveWallet(wallet);

        } catch (Exception e) {
            throw new RuntimeException("Failed to get wallet from wallet service", e);
        }
    }

    public Wallet saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}