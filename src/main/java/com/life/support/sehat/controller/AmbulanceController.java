package com.life.support.sehat.controller;

import com.life.support.sehat.models.impl.Ambulance;
import com.life.support.sehat.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ambulance")
public class AmbulanceController {

    @Autowired
    private AmbulanceService ambulanceService;

    @ResponseBody
    @RequestMapping(value = "/get-ambulances", method = RequestMethod.GET)
    public List<Ambulance> getAmbulances(@RequestParam Long healthcareId) {
        return ambulanceService.getAmbulances(healthcareId);
    }

    @ResponseBody
    @RequestMapping(value = "/get-ambulance", method = RequestMethod.GET)
    public Ambulance getAmbulance(@RequestParam Long ambulanceId){
        return ambulanceService.getAmbulance(ambulanceId);
    }
}
