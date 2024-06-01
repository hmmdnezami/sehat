package com.life.support.sehat.service;

import com.life.support.sehat.models.impl.Ambulance;

import java.util.List;

public interface AmbulanceService {
    Ambulance addAmbulance(Ambulance ambulance);

    Ambulance getAmbulance(Long id);

    List<Ambulance> getAmbulances(Long healthcareId);
}
