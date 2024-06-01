package com.life.support.sehat.repository;

import com.life.support.sehat.models.impl.Ambulance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceRepository extends CrudRepository<Ambulance, Long> {
}
