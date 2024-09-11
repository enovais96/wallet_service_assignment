package com.recargapay.transaction_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.recargapay.transaction_service.model.Deposit;
import java.util.Optional;
import java.util.Date;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

    @Query("SELECT SUM(d.value) FROM Deposit d WHERE d.idWallet = :idWallet and d.date >= :date")
    Double sumValuesFromDate(@Param("idWallet") Long idWallet, @Param("date") Date startDate);
}