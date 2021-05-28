package com.example.taxibookingapplication.domain;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taxiId;

    @NotNull
    private String taxiNumber;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;


    public Taxi() {
    }

    public Taxi(Integer taxiId, String taxiNumber, Type type, Status status) {
        this.taxiId = taxiId;
        this.taxiNumber = taxiNumber;
        this.type = type;
        this.status = status;
    }

    public Integer getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Integer taxiId) {
        this.taxiId = taxiId;
    }

    public String getTaxiNumber() {
        return taxiNumber;
    }

    public void setTaxiNumber(String taxiNumber) {
        this.taxiNumber = taxiNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
