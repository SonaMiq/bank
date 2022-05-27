package com.sonamik.bank.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class CardHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;
    private Date dateOfBirth;
    @OneToMany(mappedBy = "cardHolder")
    private Set<Card> cards;

    @OneToMany(mappedBy = "cardHolder")
    private Set<Account> accounts;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    public CardHolder(String name, String surname, Date dateOfBirth, Address address) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public CardHolder() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
