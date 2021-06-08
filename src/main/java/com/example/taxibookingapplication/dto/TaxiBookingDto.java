package com.example.taxibookingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiBookingDto {

    private Integer taxiBookingId;
    private String start;
    private String startTime;
    private String endTime;
    private String bookedTime;
    private String acceptedTime;
    private String reasonToCancel;
    private String cancelTime;
    private String taxiBookingStatus;
    private String user;
    private String taxi;
}
