package com.example.taxibookingapplication.payment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDto {

    private Integer cvv;
    private Double amount;
    private Integer customerId;
    private Integer bookingId;
}
