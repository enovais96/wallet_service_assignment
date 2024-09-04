package com.recargapay.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.recargapay.user_service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos adicionais, se necessários
}