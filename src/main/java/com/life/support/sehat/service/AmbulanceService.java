package com.life.support.sehat.service;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.HealthcareFacility;

import java.util.List;
import java.util.Optional;

public interface AmbulanceService {
    Ambulance addAmbulance(Ambulance ambulance);

    Ambulance getAmbulance(Long id);

    List<Ambulance> getAllAmbulance();

}
