package com.life.support.sehat.repository;

import com.life.support.sehat.models.impl.HealthcareFacility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends CrudRepository<HealthcareFacility, Long> {

}
