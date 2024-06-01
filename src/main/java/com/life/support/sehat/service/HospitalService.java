package com.life.support.sehat.service;

import com.life.support.sehat.models.impl.HealthcareFacility;

public interface HospitalService {
    HealthcareFacility addHealthcareFacility(HealthcareFacility healthcareFacility);

    HealthcareFacility getHealthcareFacility(Long id);
}
