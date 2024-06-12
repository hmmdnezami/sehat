package com.life.support.sehat.repository;

import com.life.support.sehat.models.HealthcareFacility;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends CrudRepository<HealthcareFacility, Long> {

    @Query("select h from HealthcareFacility h where h.city = ?1 ")
    public List<HealthcareFacility> findHospitalsByCity(String cityName);

}
