package com.life.support.sehat.controller;

import com.life.support.sehat.models.HealthcareFacility;
import com.life.support.sehat.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/healthcare", method = RequestMethod.POST)
    public HealthcareFacility addHealthCareFacility(@RequestBody HealthcareFacility healthcareFacility){
        return hospitalService.addHealthcareFacility(healthcareFacility);
    }

    @GetMapping("/healthcare")
    public List<HealthcareFacility> getAllHealthcareFacility() {
        return hospitalService.getAllHealthcareFacility();
    }

    @GetMapping(value = "/healthcare/{healthCardId}")
    public HealthcareFacility getHealthcareFacility(@RequestParam Long healthCardId){
        return hospitalService.getHealthcareFacility(healthCardId);
    }
}
