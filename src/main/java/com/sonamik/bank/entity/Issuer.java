package com.sonamik.bank.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Issuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bankCode;
    private String bankName;
    @Enumerated(EnumType.ORDINAL)
    private BankType type;
    @OneToMany(mappedBy ="issuer",cascade = CascadeType.ALL)
    private Set<Card> cards;
    @OneToMany(mappedBy = "issuer")
    private Set<Account> accounts;

    public Issuer(String bankCode, String bankName, BankType type) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.type =type;
    }
    public Issuer(){

    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setType(BankType type) {
        this.type = type;
    }

    public String getBankCode() {
        return bankCode;
    }

    public BankType getType() {
        return type;
    }

    public String getBankName() {
        return bankName;
    }
}
 