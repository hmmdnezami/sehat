package com.life.support.sehat.models;

import jakarta.persistence.*;

@Entity(name = "fare")
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fid;
    @OneToOne(mappedBy = "fare")
    private Booking booking;
    private FareStatus fareStatus;
    private FareMode mode;
    private double amount;

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
        if(booking!=null){
            booking.setFare(this);
        }
    }

    public FareStatus getFareStatus() {
        return fareStatus;
    }

    public void setFareStatus(FareStatus fareStatus) {
        this.fareStatus = fareStatus;
    }

    public FareMode getMode() {
        return mode;
    }

    public void setMode(FareMode mode) {
        this.mode = mode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
