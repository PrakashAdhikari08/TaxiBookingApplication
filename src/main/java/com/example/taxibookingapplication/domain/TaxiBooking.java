package com.example.taxibookingapplication.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity

public class TaxiBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    private long customerId;

    private String reasonToCancel;

    private Date cancelTime;


    private Integer taxiId;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BookingStatus taxiBookingStatus;

    public TaxiBooking(int taxiBookingId, String start, Date startTime, Date endTime, String bookedTime, String acceptedTime, long customerId, String reasonToCancel, Date cancelTime, Integer taxiId) {
        this.taxiBookingId = taxiBookingId;
        this.start = start;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookedTime = bookedTime;
        this.acceptedTime = acceptedTime;
        this.customerId = customerId;
        this.reasonToCancel = reasonToCancel;
        this.cancelTime = cancelTime;
        this.taxiId = taxiId;
    }

    public TaxiBooking() {
    }

    public int getTaxiBookingId() {
        return taxiBookingId;
    }

    public void setTaxiBookingId(int taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(String bookedTime) {
        this.bookedTime = bookedTime;
    }

    public String getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(String acceptedTime) {
        this.acceptedTime = acceptedTime;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getReasonToCancel() {
        return reasonToCancel;
    }

    public void setReasonToCancel(String reasonToCancel) {
        this.reasonToCancel = reasonToCancel;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Integer getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Integer taxiId) {
        this.taxiId = taxiId;
    }

    @Override
    public String toString() {
        return "TaxiBooking{" +
                "taxiBookingId=" + taxiBookingId +
                ", start='" + start + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", bookedTime='" + bookedTime + '\'' +
                ", acceptedTime='" + acceptedTime + '\'' +
                ", customerId=" + customerId +
                ", reasonToCancel='" + reasonToCancel + '\'' +
                ", cancelTime=" + cancelTime +
                ", taxiId=" + taxiId +
                '}';
    }
}
