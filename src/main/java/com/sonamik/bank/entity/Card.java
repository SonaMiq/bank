package com.sonamik.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.ORDINAL)
    private CardType cardType;
    @Min(1000)
    @Max(value = 500000)
    private long balance;
    @Column(unique = true)
//    @Pattern(regexp = "^[0-9]{4}\\-[0-9]{4}\\-[0-9]{4}\\-[0-9]{4}")
    @Pattern(regexp = "\\d{4}-\\d{4}-\\d{4}-\\d{4}")
    private String cardNumber;
    @JsonIgnore
    private Date exp = java.sql.Date.valueOf(LocalDate.now().plusYears(5).getYear() +
            "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth());
    private String cvc;

    private CardStatus status = CardStatus.CREATED;
    @Pattern(regexp = "^[0-9]{4}")
    @Value("${encrypted.property}")
    private String pin;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Issuer issuer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CardHolder cardHolder;

    public Card(CardType cardType, long balance, String cardNumber, String cvc, String pin, Issuer issuer) {
        this.cardType = cardType;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.pin = pin;
        this.issuer = issuer;
    }

    public Card() {

    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setCardHolder(CardHolder cardHolder){this.cardHolder=cardHolder;}

    public CardStatus getStatus() {
        return status;
    }

    public long getBalance() {
        return balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public String getPin() {
        return pin;
    }

    public Date getExp() {
        return exp;
    }

    //public Issuer getIssuer() {
       // return issuer;
   // }
}
