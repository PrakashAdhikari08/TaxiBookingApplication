package com.example.taxibookingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiDto {

    private Integer id;
    private String taxiNumber;
    private String type;
    private String Status;
    private String User;

}
