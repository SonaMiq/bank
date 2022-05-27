package com.sonamik.bank.entity;

public enum BankType {
    CENTRAL(0),COMMERCIAL(1),SPECIALISED(2),COPERATIVE(3);

    private final int i;
     BankType(int i){
        this.i=i;
    }

}
