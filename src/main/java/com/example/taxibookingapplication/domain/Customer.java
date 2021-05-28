package com.example.taxibookingapplication.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private Date doB;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    private String email;

    public Customer() {
    }

    public Customer(Integer customerId, String name, String address, Date doB, Gender gender, String email) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.doB = doB;
        this.gender = gender;
        this.email = email;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", doB=" + doB +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
