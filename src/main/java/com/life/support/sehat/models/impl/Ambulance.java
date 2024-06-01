package com.life.support.sehat.models.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Entity(name = "ambulance")
public class Ambulance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long amid;
    private String name;
    private String driver;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private HealthcareFacility healthcareFacility;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public HealthcareFacility getHealthcareFacility() {
        return healthcareFacility;
    }

    public void setHealthcareFacility(HealthcareFacility healthcareFacility) {
        this.healthcareFacility = healthcareFacility;
    }

    public long getAmid() {
        return amid;
    }

    public void setAmid(long amid) {
        this.amid = amid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
