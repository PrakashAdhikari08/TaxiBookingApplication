package com.example.taxibookingapplication.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer taxiBookingId;

    @NotNull
    private String start;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotNull
    private LocalTime bookedTime;

    @NotNull
    private LocalTime acceptedTime;

    private String reasonToCancel;

    private LocalTime cancelTime;


    @Enumerated(EnumType.STRING)
    @NotNull
    private BookingStatus taxiBookingStatus;

    @OneToOne
    private User user;

    @OneToOne
    private Taxi taxi;
}
