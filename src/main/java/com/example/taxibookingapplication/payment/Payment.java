package com.example.taxibookingapplication.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Integer customerId;

    private String cardNumber;

    private Integer cvv;


}
