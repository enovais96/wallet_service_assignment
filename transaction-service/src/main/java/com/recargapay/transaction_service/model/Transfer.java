package com.recargapay.transaction_service.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransfer;
    @Column(nullable = false)
    private Long idWalletWithdraw;
    @Column(nullable = false)
    private Long idWalletDeposit;
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

    public Long getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(Long idTransfer) {
        this.idTransfer = idTransfer;
    }

    public Long getIdWalletWithdraw() {
        return idWalletWithdraw;
    }

    public void setIdWalletWithdraw(Long idWalletWithdraw) {
        this.idWalletWithdraw = idWalletWithdraw;
    }

    public Long getIdWalletDeposit() {
        return idWalletDeposit;
    }

    public void setIdWalletDeposit(Long idWalletDeposit) {
        this.idWalletDeposit = idWalletDeposit;
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