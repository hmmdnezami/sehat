package com.life.support.sehat.controller;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v2")
public class AmbulanceController {

    @Autowired
    private AmbulanceService ambulanceService;

    @ResponseBody
    @RequestMapping(value = "/ambulances", method = RequestMethod.POST)
    public Ambulance addAmbulances(@RequestBody Ambulance ambulance) {
        return ambulanceService.addAmbulance(ambulance);
    }


    @GetMapping(value = "/ambulances")
    public List<Ambulance> getAllAmbulance(){ return ambulanceService.getAllAmbulance(); }

    @ResponseBody
    @RequestMapping(value = "/ambulance/{ambulanceId}", method = RequestMethod.GET)
    public Ambulance getAmbulance(@RequestParam Long ambulanceId){
        return ambulanceService.getAmbulance(ambulanceId);
    }
}
