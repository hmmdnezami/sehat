package com.life.support.sehat.service;

import com.life.support.sehat.models.Healthcare;

import java.util.List;

public interface HospitalService {
    Healthcare addHealthcareFacility(Healthcare healthcare);

    Healthcare getHealthcareFacility(Long id);

    List<Healthcare> getAllHealthcareFacility();

    List<Healthcare> getAllHealthCareInCity(String cityName);
}
