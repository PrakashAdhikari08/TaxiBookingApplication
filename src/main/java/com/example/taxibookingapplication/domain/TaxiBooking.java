package com.example.taxibookingapplication.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Date startTime;

    @NotNull
    private Date endTime;

    @NotNull
    private String bookedTime;

    @NotNull
    private String acceptedTime;

    private String reasonToCancel;

    private Date cancelTime;


    @Enumerated(EnumType.STRING)
    @NotNull
    private BookingStatus taxiBookingStatus;

    @OneToOne
    private User user;

    @OneToOne
    private Taxi taxi;
}
