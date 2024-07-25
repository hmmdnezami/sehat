package com.life.support.sehat.repository;

import com.life.support.sehat.models.Ambulance;
import com.life.support.sehat.models.HealthcareFacility;
import com.life.support.sehat.models.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanceRepository extends CrudRepository<Ambulance, Long> {

//    @Query("select h from Ambulance h where h.city = ?1")
    List<Ambulance> findAmbulanceByCity(String cityName);

    @Query(value = "SELECT id, name, latitude, longitude, " +
            "ST_Distance_Sphere(point(longitude, latitude), point(:longitude, :latitude)) AS distance " +
            "FROM ambulance " +
            "ORDER BY distance " +
            "LIMIT :limit", nativeQuery = true)
    List<Ambulance> findAmbulanceByCityAndLocation(@Param("longitude") double longitude,
                                                   @Param("latitude") double latitude,
                                                   @Param("limit") int limit);

//    List<Ambulance> findAmbulanceNearUser(String city);
}
