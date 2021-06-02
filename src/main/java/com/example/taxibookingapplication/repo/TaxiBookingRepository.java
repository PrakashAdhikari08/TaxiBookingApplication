package com.example.taxibookingapplication.repo;

import com.example.taxibookingapplication.domain.BookingStatus;
import com.example.taxibookingapplication.domain.TaxiBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiBookingRepository extends JpaRepository<TaxiBooking, Integer> {
}
