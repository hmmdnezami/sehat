package com.life.support.sehat.controller;

import com.life.support.sehat.models.impl.HealthcareFacility;
import com.life.support.sehat.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/healthcare")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;
    @ResponseBody
    @RequestMapping(value = "/add-healthcare", method = RequestMethod.POST)
    public HealthcareFacility addHealthCareFacility(@RequestBody HealthcareFacility healthcareFacility){
        return hospitalService.addHealthcareFacility(healthcareFacility);
    }

    @ResponseBody
    @RequestMapping(value = "/get-healthcare", method = RequestMethod.GET)
    public HealthcareFacility getHealthcareFacility(@RequestParam Long id){
        return hospitalService.getHealthcareFacility(id);
    }
}
