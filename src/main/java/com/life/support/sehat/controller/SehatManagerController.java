package com.life.support.sehat.controller;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.Booking;
import com.life.support.sehat.models.HealthcareFacility;
import com.life.support.sehat.service.SehatManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class SehatManagerController {

    @Autowired
    private SehatManagerService sehatManagerService;

    @GetMapping(value = "/hospital/city/{cityName}")
    public List<HealthcareFacility> getAllHospitalByCity(@PathVariable String cityName) {
        return sehatManagerService.getAllHospitals(cityName);
    }

    @GetMapping(value = "/ambulance/city/{cityName}")
    public List<Ambulance> findAmbulanceNearToUser(@PathVariable String cityName) {
        return sehatManagerService.getAllAmbulaceNearToUser(cityName);
    }

    @PostMapping(value ="/booking/user/{userId}")
    public Booking bookingForUser(@RequestBody HealthcareFacility healthcareFacility,
                                  @RequestBody Ambulance ambulance, @PathVariable Long userId) {
        return sehatManagerService.bookingForUser(healthcareFacility, ambulance, userId);
    }

}
