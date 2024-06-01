package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.impl.Ambulance;
import com.life.support.sehat.repository.AmbulanceRepository;
import com.life.support.sehat.repository.HospitalRepository;
import com.life.support.sehat.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Ambulance> getAmbulances(Long healthcareId) {
        return hospitalRepository.findById(healthcareId).orElseThrow().getAmbulances();
    }
}
