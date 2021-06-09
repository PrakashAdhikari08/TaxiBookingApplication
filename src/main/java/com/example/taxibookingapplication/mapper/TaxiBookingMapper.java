package com.example.taxibookingapplication.mapper;

import com.example.taxibookingapplication.domain.BookingStatus;
import com.example.taxibookingapplication.domain.TaxiBooking;
import com.example.taxibookingapplication.dto.TaxiBookingDto;

public class TaxiBookingMapper {

    public  static TaxiBookingDto toTaxiBookingDto(TaxiBooking taxiBooking){
        TaxiBookingDto taxiBookingDto = new TaxiBookingDto();

        taxiBookingDto.setTaxiBookingId(taxiBooking.getTaxiBookingId());
       taxiBookingDto.setTaxiID((taxiBooking.getTaxi().getId()));
       taxiBookingDto.setUserID(taxiBooking.getUser().getId());
        taxiBookingDto.setTaxiBookingStatus(taxiBookingDto.getTaxiBookingStatus());
        taxiBookingDto.setBookedTime(taxiBooking.getBookedTime());
        taxiBookingDto.setTaxiBookingId(taxiBookingDto.getTaxiBookingId());
        taxiBookingDto.setAcceptedTime(taxiBookingDto.getAcceptedTime());
        taxiBookingDto.setCancelTime(taxiBookingDto.getCancelTime());
        taxiBookingDto.setBookedTime(taxiBookingDto.getBookedTime());
        taxiBookingDto.setReasonToCancel(taxiBookingDto.getReasonToCancel());
        return  taxiBookingDto;
    }

    public static TaxiBooking toTaxiBooking(TaxiBookingDto taxiBookingDto){
        TaxiBooking taxiBooking = new TaxiBooking();

        taxiBooking.setTaxiBookingStatus(BookingStatus.valueOf(taxiBookingDto.getTaxiBookingStatus()));
        taxiBooking.setTaxiBookingId(taxiBookingDto.getTaxiBookingId());
//        taxiBooking.setTaxi(taxiBookingDto.getTaxiID());
        taxiBooking.setCancelTime(taxiBookingDto.getCancelTime());
        taxiBooking.setBookedTime(taxiBookingDto.getBookedTime());
        taxiBooking.setReasonToCancel(taxiBookingDto.getReasonToCancel());
        taxiBooking.setBookedTime(taxiBookingDto.getBookedTime());
        taxiBooking.setEndTime(taxiBookingDto.getEndTime());
        taxiBooking.setAcceptedTime(taxiBookingDto.getAcceptedTime());
        taxiBooking.setStart(taxiBookingDto.getStart());

        return taxiBooking;
    }
}
