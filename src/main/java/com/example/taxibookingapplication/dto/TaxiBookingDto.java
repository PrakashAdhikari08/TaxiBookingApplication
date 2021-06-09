package com.example.taxibookingapplication.dto;

import com.example.taxibookingapplication.domain.Taxi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiBookingDto {

    private Integer taxiBookingId;
    private String start;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime bookedTime;
    private LocalTime acceptedTime;
    private String reasonToCancel;
    private LocalTime cancelTime;
    private String taxiBookingStatus;
    private Integer userID;
    private Integer taxiID;
}
