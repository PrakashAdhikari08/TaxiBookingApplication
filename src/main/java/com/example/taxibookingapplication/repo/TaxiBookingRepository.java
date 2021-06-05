package com.example.taxibookingapplication.repo;

import com.example.taxibookingapplication.domain.BookingStatus;
import com.example.taxibookingapplication.domain.TaxiBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TaxiBookingRepository extends JpaRepository<TaxiBooking, Integer> {

    @Query(value = "Select * from taxi_booking tb where tb.taxi_ID =:taxiID and tb.customer_ID =:customerID", nativeQuery = true)
    TaxiBooking getTaxiBookingByCustomerAndTaxiId(@Param("taxiID") Integer taxiID, @Param("customerID")Integer customerID);


}
