package com.life.support.sehat.models;


import jakarta.persistence.Entity;

@Entity(name = "detailedlocation")
public class DetailedLocation {

    private String city;
    private String locality;
    private Location location;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
