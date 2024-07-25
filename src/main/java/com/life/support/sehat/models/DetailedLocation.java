package com.life.support.sehat.models;


import jakarta.persistence.*;

@Entity(name = "detailedlocation")
public class DetailedLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long did;
    private String city;
    private String locality;
    @OneToOne
    private Location location;

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

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
