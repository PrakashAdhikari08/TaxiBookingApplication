package com.example.taxibookingapplication.dto;

import com.example.taxibookingapplication.domain.Status;
import com.example.taxibookingapplication.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiDto {

    private Integer Id;
    private String taxiNumber;
    private Type type;
    private Status Status;
    private Integer userId;

}
