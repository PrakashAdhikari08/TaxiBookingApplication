package com.example.taxibookingapplication.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "optimized-sequence")
    private Integer taxiBookingId;

    @NotNull
    private String start;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    @NotNull
    @CreationTimestamp
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
