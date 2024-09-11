package com.recargapay.transaction_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.recargapay.transaction_service.model.Wallet;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {}