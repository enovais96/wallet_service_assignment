package com.recargapay.transaction_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recargapay.transaction_service.model.Withdraw;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.model.Wallet;
import com.recargapay.transaction_service.repository.WithdrawRepository;
import com.recargapay.transaction_service.service.WalletService;
import com.recargapay.transaction_service.exception.ValueNotAvaiableException;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class WithdrawService {

    @Autowired
    private WithdrawRepository withdrawRepository;

    @Autowired
    private WalletService walletService;

    public Withdraw createWithdraw(Withdraw withdraw) {
        Wallet wallet = walletService.getWalletById(withdraw.getIdWallet());

        if(wallet.getValueAvaiable() < withdraw.getValue()){
            throw new ValueNotAvaiableException("Wallet only have: " + wallet.getValueAvaiable() + " avaiable.");
        }

        wallet.setValueAvaiable(wallet.getValueAvaiable() - withdraw.getValue());

        walletService.saveWallet(wallet);

        return withdrawRepository.save(withdraw);
    }

    public Withdraw getWalletByIdByDate(Withdraw withdraw, Date date) {
        Wallet wallet = walletService.getWalletById(withdraw.getIdWallet());

        if(wallet.getValueAvaiable() < withdraw.getValue()){
            throw new ValueNotAvaiableException("Wallet only have: " + wallet.getValueAvaiable() + " avaiable.");
        }

        wallet.setValueAvaiable(wallet.getValueAvaiable() - withdraw.getValue());

        walletService.saveWallet(wallet);

        return withdrawRepository.save(withdraw);
    }

    public Double getSumOfValuesFromDate(Long idWallet, Date startDate) {
        return withdrawRepository.sumValuesFromDate(idWallet, startDate);
    }
}