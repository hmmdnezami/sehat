package com.life.support.sehat.models.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "healthcare")
public class HealthcareFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ambulance> ambulances;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        if(location==null){
            if(this.location!=null){
                this.location.setHealthcareFacility(null);
            }
        }
        else{
            location.setHealthcareFacility(this);
        }
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        if(contact==null){
            if(this.contact!=null){
                this.contact.setHealthcareFacility(null);
            }
        }
        else{
            contact.setHealthcareFacility(this);
        }
        this.contact = contact;
    }

    public List<Ambulance> getAmbulances() {
        return ambulances;
    }

    public void setAmbulances(List<Ambulance> ambulances) {
        this.ambulances = ambulances;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
