package com.life.support.sehat.service;

import com.life.support.sehat.models.HealthcareFacility;

import java.util.List;

public interface HospitalService {
    HealthcareFacility addHealthcareFacility(HealthcareFacility healthcareFacility);

    HealthcareFacility getHealthcareFacility(Long id);

    List<HealthcareFacility> getAllHealthcareFacility();

    List<HealthcareFacility> getAllHealthCareInCity(String cityName);
}
