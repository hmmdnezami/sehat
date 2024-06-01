package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.impl.HealthcareFacility;
import com.life.support.sehat.repository.HospitalRepository;
import com.life.support.sehat.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public HealthcareFacility addHealthcareFacility(HealthcareFacility healthcareFacility) {
        return hospitalRepository.save(healthcareFacility);
    }

    @Override
    public HealthcareFacility getHealthcareFacility(Long id) {
        Optional<HealthcareFacility> healthcareFacility = hospitalRepository.findById(id);
        return healthcareFacility.orElse(null);
    }
}
