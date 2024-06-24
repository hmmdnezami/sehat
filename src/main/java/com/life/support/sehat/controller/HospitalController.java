package com.life.support.sehat.controller;

import com.life.support.sehat.models.Healthcare;
import com.life.support.sehat.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v2")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @RequestMapping(value = "/healthcare", method = RequestMethod.POST)
    public Healthcare addHealthCareFacility(@RequestBody Healthcare healthcare){
        return hospitalService.addHealthcareFacility(healthcare);
    }

    @GetMapping("/healthcare")
    public List<Healthcare> getAllHealthcareFacility() {
        return hospitalService.getAllHealthcareFacility();
    }

    @GetMapping(value = "/healthcare/{healthCardId}")
    public Healthcare getHealthcareFacility(@RequestParam Long healthCardId){
        return hospitalService.getHealthcareFacility(healthCardId);
    }

    @GetMapping(value ="/heathCare/{cityName}")
    public List<Healthcare> getAllHealthCareinCity(@RequestParam String cityName) {
        return hospitalService.getAllHealthCareInCity(cityName);
    }
}
