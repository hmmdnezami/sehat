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
    private List<String> email;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<String> phone;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.LAZY)
    private HealthcareFacility healthcareFacility;

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

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }
}
