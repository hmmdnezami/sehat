package com.life.support.sehat.models.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lid;
    private String name;
    private String latitude;
    private String longitude;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.LAZY)
    private HealthcareFacility healthcareFacility;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.LAZY)
    private Ambulance ambulance;

    public Ambulance getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

    public HealthcareFacility getHealthcareFacility() {
        return healthcareFacility;
    }

    public void setHealthcareFacility(HealthcareFacility healthcareFacility) {
        this.healthcareFacility = healthcareFacility;
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
