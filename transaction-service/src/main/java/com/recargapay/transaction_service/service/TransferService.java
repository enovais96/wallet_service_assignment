package com.recargapay.transaction_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recargapay.transaction_service.model.Transfer;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.model.Wallet;
import com.recargapay.transaction_service.repository.TransferRepository;
import com.recargapay.transaction_service.service.WalletService;
import com.recargapay.transaction_service.exception.ValueNotAvaiableException;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WalletService walletService;

    public Transfer createTransfer(Transfer transfer) {
        Wallet walletWithdraw = walletService.getWalletById(transfer.getIdWalletWithdraw());
        Wallet walletDeposit  = walletService.getWalletById(transfer.getIdWalletDeposit());

        if(walletWithdraw.getValueAvaiable() < transfer.getValue()){
            throw new ValueNotAvaiableException("Wallet to withdraw only have: " + walletWithdraw.getValueAvaiable() + " avaiable.");
        }

        walletWithdraw.setValueAvaiable(walletWithdraw.getValueAvaiable() - transfer.getValue());
        walletService.saveWallet(walletWithdraw);

        walletDeposit.setValueAvaiable(walletDeposit.getValueAvaiable() + transfer.getValue());
        walletService.saveWallet(walletDeposit);

        return transferRepository.save(transfer);
    }

    public Double getSumOfValuesSendedFromDate(Long idWallet, Date startDate) {
        return transferRepository.sumValuesSendedFromDate(idWallet, startDate);
    }

    public Double getSumOfValuesRecievedFromDate(Long idWallet, Date startDate) {
        return transferRepository.sumValuesRecievedFromDate(idWallet, startDate);
    }
}