package com.recargapay.transaction_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.recargapay.transaction_service.model.Withdraw;
import java.util.Optional;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw, Long> {

    @Query("SELECT SUM(w.value) FROM Withdraw w WHERE w.idWallet = :idWallet and w.date >= :date")
    Double sumValuesFromDate(@Param("idWallet") Long idWallet, @Param("date") Date startDate);
}