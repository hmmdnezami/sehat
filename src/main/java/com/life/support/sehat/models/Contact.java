package com.life.support.sehat.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cid;
    private String name;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> email;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phone;
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

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }
}
