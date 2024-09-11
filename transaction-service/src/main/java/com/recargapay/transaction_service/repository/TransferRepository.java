package com.recargapay.transaction_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.recargapay.transaction_service.model.Transfer;
import java.util.Optional;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query("SELECT SUM(t.value) FROM Transfer t WHERE t.idWalletWithdraw = :idWallet and t.date >= :date")
    Double sumValuesSendedFromDate(@Param("idWallet") Long idWallet, @Param("date") Date startDate);

    @Query("SELECT SUM(t.value) FROM Transfer t WHERE t.idWalletDeposit = :idWallet and t.date >= :date")
    Double sumValuesRecievedFromDate(@Param("idWallet") Long idWallet, @Param("date") Date startDate);
}