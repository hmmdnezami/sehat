package com.life.support.sehat.repository;

import com.life.support.sehat.models.Healthcare;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends CrudRepository<Healthcare, Long> {

    @Query("select h from Healthcare h where h.city = ?1 ")
    public List<Healthcare> findHospitalsByCity(String cityName);

}
