package com.recargapay.transaction_service.model;

import jakarta.persistence.*;

@Entity
public class Wallet {

    @Id
    private Long idWallet;
    @Column(nullable = false)
    private Long idUser;
    @Column(nullable = false)
    private String nameUser;
    private Double valueAvaiable;

    @PrePersist
    public void prePersist() {
        if (this.valueAvaiable == null) {
            this.valueAvaiable = 0.0;
        }
    }

    public Long getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(Long idWallet) {
        this.idWallet = idWallet;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Double getValueAvaiable() {
        return valueAvaiable;
    }

    public void setValueAvaiable(Double valueAvaiable) {
        this.valueAvaiable = valueAvaiable;
    }
}