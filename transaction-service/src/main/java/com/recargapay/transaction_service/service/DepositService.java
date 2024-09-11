package com.recargapay.transaction_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recargapay.transaction_service.model.Deposit;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.model.Wallet;
import com.recargapay.transaction_service.repository.DepositRepository;
import com.recargapay.transaction_service.service.WalletService;


import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private WalletService walletService;

    public Deposit createDeposit(Deposit deposit) {
        Wallet wallet = walletService.getWalletById(deposit.getIdWallet());

        wallet.setValueAvaiable(wallet.getValueAvaiable() + deposit.getValue());

        walletService.saveWallet(wallet);

        return depositRepository.save(deposit);
    }

    public Double getSumOfValuesFromDate(Long idWallet, Date startDate) {
        return depositRepository.sumValuesFromDate(idWallet, startDate);
    }

}