package com.recargapay.transaction_service.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeposit;
    @Column(nullable = false)
    private Long idWallet;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private Double value;

    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = new Date();
        }
    }

    public Long getIdDeposit() {
        return idDeposit;
    }

    public void setIdDeposit(Long idDeposit) {
        this.idDeposit = idDeposit;
    }

    public Long getIdWallet() {
        return idWallet;
    }

    public void setIdWallet(Long idWallet) {
        this.idWallet = idWallet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}