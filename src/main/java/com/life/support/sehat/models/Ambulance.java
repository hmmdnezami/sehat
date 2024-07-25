package com.life.support.sehat.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "ambulance")
public class Ambulance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long amid;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    private Status status;
    private long currentDriver ;

    private String city;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Location location;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AmbulanceHistory> ambulanceHistory;

    public long getCurrentDriver() {
        return currentDriver;
    }

    public void setCurrentDriver(long currentDriver) {
        this.currentDriver = currentDriver;
    }

    public List<AmbulanceHistory> getAmbulanceHistory() {
        return ambulanceHistory;
    }

    public void setAmbulanceHistory(List<AmbulanceHistory> ambulanceHistory) {
        this.ambulanceHistory = ambulanceHistory;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getAmid() {
        return amid;
    }

    public void setAmid(long amid) {
        this.amid = amid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        location.setAmbulance(this);
    }

    public void removeLocation(Location location){
        if(location!=null){
            location.setAmbulance(null);
        }
        this.location=null;
    }
}
