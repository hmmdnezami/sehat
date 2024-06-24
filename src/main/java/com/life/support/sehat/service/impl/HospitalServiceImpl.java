package com.life.support.sehat.service.impl;

import com.life.support.sehat.models.Healthcare;
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
    public Healthcare addHealthcareFacility(Healthcare healthcare) {
        String city = healthcare.getAddress()!=null? healthcare.getAddress().getCity():null;
        if (city != null)
            healthcare.setCity(city);
        return hospitalRepository.save(healthcare);
    }

    @Override
    public Healthcare getHealthcareFacility(Long id) {
        Optional<Healthcare> healthcareFacility = hospitalRepository.findById(id);
        return healthcareFacility.orElse(null);
    }

    @Override
    public List<Healthcare> getAllHealthcareFacility() {
        return (List<Healthcare>) hospitalRepository.findAll();
    }

    @Override
    public List<Healthcare> getAllHealthCareInCity(String cityName) {
        return hospitalRepository.findHospitalsByCity(cityName);
    }
}
