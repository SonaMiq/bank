package com.sonamik.bank.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp = "^[A-Z]{2}\\[0-9][A-Z]{8}")
    private String iban;
    private long balance;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Issuer issuer;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CardHolder cardHolder;

    public Account(String iban, long balance, Issuer issuer, CardHolder cardHolder) {
        this.iban = iban;
        this.balance = balance;
        this.issuer = issuer;
        this.cardHolder = cardHolder;
    }
    public Account(){

    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getBalance() {
        return balance;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }
}
