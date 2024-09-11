package com.recargapay.transaction_service.json;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletJson {

    @JsonProperty("idWallet")
    private Long idWallet;
    @JsonProperty("idUser")
    private Long idUser;
    @JsonProperty("nameUser")
    private String nameUser;

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
}