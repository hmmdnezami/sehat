package com.life.support.sehat.models;


import jakarta.persistence.*;


@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userName;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private HealthcareFacility healthcareFacility;

    private String ambulanceNumber ;
    private String driverName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HealthcareFacility getHealthcareFacility() {
        return healthcareFacility;
    }

    public void setHealthcareFacility(HealthcareFacility healthcareFacility) {
        this.healthcareFacility = healthcareFacility;
    }

    public String getAmbulanceNumber(String number) {
        return ambulanceNumber;
    }

    public void setAmbulanceNumber(String ambulanceNumber) {
        this.ambulanceNumber = ambulanceNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
