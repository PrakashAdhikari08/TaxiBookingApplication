package com.example.taxibookingapplication.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRecord {

    private Integer cvv;
    private Double amount;
    private Integer customerId;
}
