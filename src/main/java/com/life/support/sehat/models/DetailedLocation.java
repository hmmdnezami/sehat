package com.life.support.sehat.models;


import jakarta.persistence.Entity;

@Entity(name = "detailedlocation")
public class DetailedLocation extends Location{

    private String city;
    private String locality;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
