package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.HealthcareFacility;
import com.life.support.sehat.repository.HospitalRepository;
import com.life.support.sehat.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;



    @Override
    public HealthcareFacility addHealthcareFacility(HealthcareFacility healthcareFacility) {
        String city = healthcareFacility.getAddress()!=null?healthcareFacility.getAddress().getCity():null;
        healthcareFacility.setCity(city);


        return hospitalRepository.save(healthcareFacility);
    }

    @Override
    public HealthcareFacility getHealthcareFacility(Long id) {
        Optional<HealthcareFacility> healthcareFacility = hospitalRepository.findById(id);
        return healthcareFacility.orElse(null);
    }

    @Override
    public List<HealthcareFacility> getAllHealthcareFacility() {
        return (List<HealthcareFacility>) hospitalRepository.findAll();
    }

    @Override
    public List<HealthcareFacility> getAllHealthCareInCity(String cityName) {
        return hospitalRepository.findHospitalsByCity(cityName);
    }
}
