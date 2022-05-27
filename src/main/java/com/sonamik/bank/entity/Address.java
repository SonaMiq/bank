package com.sonamik.bank.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;
    private String building;
    private String home;
    private String zip;

    @OneToMany(mappedBy = "address")
    private Set<CardHolder> cardHolders;

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Address(String city, String street, String building, String home, String zip) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.home = home;
        this.zip = zip;
    }
   public Address(){

   }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getHome() {
        return home;
    }

    public String getZip() {
        return zip;
    }
}
