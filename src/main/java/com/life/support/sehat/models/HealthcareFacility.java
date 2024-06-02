package com.life.support.sehat.models;

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
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updateAt;

    private Address address;

    private String city ;

    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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



    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
