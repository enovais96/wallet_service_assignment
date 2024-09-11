package com.recargapay.transaction_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recargapay.transaction_service.model.Wallet;
import com.recargapay.transaction_service.model.ErrorResponse;
import com.recargapay.transaction_service.json.WalletJson;
import com.recargapay.transaction_service.service.DepositService;
import com.recargapay.transaction_service.service.WalletService;
import com.recargapay.transaction_service.service.WithdrawService;
import com.recargapay.transaction_service.service.TransferService;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class BalanceService {

    @Autowired
    private WalletService walletService;

    @Autowired
    private DepositService depositService;

    @Autowired
    private TransferService transferService;

    @Autowired
    private WithdrawService withdrawService;

    public double getWalletByIdByDate(Long idWallet, String dateBalance) {
        Date dateFormated = this.convertDateFromString(dateBalance);
        Wallet wallet = walletService.getWalletById(idWallet);
        Double balance = wallet.getValueAvaiable();

        Double deposits = depositService.getSumOfValuesFromDate(idWallet, dateFormated);
        Double withdraw = withdrawService.getSumOfValuesFromDate(idWallet, dateFormated);
        Double transferSended = transferService.getSumOfValuesSendedFromDate(idWallet, dateFormated);
        Double transferRecieved = transferService.getSumOfValuesRecievedFromDate(idWallet, dateFormated);

        balance -= (deposits == null ? 0 : deposits);
        balance += (withdraw == null ? 0 : withdraw);
        balance += (transferSended == null ? 0 : transferSended);
        balance -= (transferRecieved == null ? 0 : transferRecieved);

        return balance;
    }

    public Date convertDateFromString(String dateBalance) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate;

        try {
            parsedDate = dateFormat.parse(dateBalance);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + dateBalance);
        }

        return parsedDate;
    }
}