package com.life.support.sehat.controller;

import com.life.support.sehat.dto.Driver;
import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.Booking;
import com.life.support.sehat.models.Healthcare;
import com.life.support.sehat.service.SehatManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v2")
public class SehatManagerController {

    @Autowired
    private SehatManagerService sehatManagerService;

    @GetMapping(value = "/hospital/city/{cityName}")
    public List<Healthcare> getAllHospitalByCity(@PathVariable String cityName) {
        return sehatManagerService.getAllHospitals(cityName);
    }

    @GetMapping(value = "/ambulance/city/{cityName}")
    public List<Ambulance> findAmbulanceNearToUser(@PathVariable String cityName) {
        return sehatManagerService.getAllAmbulaceNearToUser(cityName);
    }

    @PostMapping(value ="/booking/user/{userId}")
    public Booking bookingForUser(@RequestBody Healthcare healthcare,
                                  @RequestBody Ambulance ambulance, @PathVariable Long userId) {
        return sehatManagerService.bookingForUser(healthcare, ambulance, userId);
    }

    @GetMapping("/driver/{status}")
    public List<Driver> getAllDriverWithoutAmbulance(@PathVariable String status) {
        return sehatManagerService.findAllDriverWithoutAmbulance(status);
    }

    @PutMapping("/driver/ambulance/{driverId}")
    public Driver registedAmbulanceToDriver(@PathVariable Long driverId, @RequestBody Ambulance ambulance) {
        return sehatManagerService.registedAmbulanceToDriver(driverId, ambulance);
    }

}
