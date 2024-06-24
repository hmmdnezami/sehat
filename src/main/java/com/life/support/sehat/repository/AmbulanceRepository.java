package com.life.support.sehat.repository;

import com.life.support.sehat.models.Ambulance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanceRepository extends CrudRepository<Ambulance, Long> {

//    @Query("select h from Ambulance h where h.city = ?1")
    List<Ambulance> findAmbulanceByCity(String cityName);
}
