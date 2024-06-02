package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.HealthcareFacility;
import com.life.support.sehat.repository.AmbulanceRepository;
import com.life.support.sehat.repository.HospitalRepository;
import com.life.support.sehat.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmbulanceServiceImpl implements AmbulanceService {

    @Autowired
    private AmbulanceRepository ambulanceRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Ambulance addAmbulance(Ambulance ambulance) {
        return ambulanceRepository.save(ambulance);
    }

    @Override
    public Ambulance getAmbulance(Long id) {
        return ambulanceRepository.findById(id).orElse(null);
    }


    @Override
    public List<Ambulance> getAllAmbulance() {
        return (List<Ambulance>) ambulanceRepository.findAll();
    }

}
