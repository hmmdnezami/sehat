package com.life.support.sehat.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bid;
    private long userId;
    private long driverId;
    private long ambulanceId;
    @OneToOne(cascade = CascadeType.ALL)
    private DetailedLocation pickup;           //using detailed location as all the details should be in record
    private long targetHealthcareId;
    private BookingStatus BookingStatus;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Fare fare;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private Date rideStartAt;
    private Date rideEndAt;

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public DetailedLocation getPickup() {
        return pickup;
    }

    public void setPickup(DetailedLocation pickup) {
        this.pickup = pickup;
    }

    public long getTargetHealthcareId() {
        return targetHealthcareId;
    }

    public void setTargetHealthcareId(long targetHealthcareId) {
        this.targetHealthcareId = targetHealthcareId;
    }

    public com.life.support.sehat.models.BookingStatus getBookingStatus() {
        return BookingStatus;
    }

    public void setBookingStatus(com.life.support.sehat.models.BookingStatus bookingStatus) {
        BookingStatus = bookingStatus;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
        if(fare!=null){
            fare.setBooking(this);
        }
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getAmbulanceId() {
        return ambulanceId;
    }

    public void setAmbulanceId(long ambulanceId) {
        this.ambulanceId = ambulanceId;
    }

    public Date getRideStartAt() {
        return rideStartAt;
    }

    public void setRideStartAt(Date rideStartAt) {
        this.rideStartAt = rideStartAt;
    }

    public Date getRideEndAt() {
        return rideEndAt;
    }

    public void setRideEndAt(Date rideEndAt) {
        this.rideEndAt = rideEndAt;
    }
}
