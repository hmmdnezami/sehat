package com.life.support.sehat.service;

import com.life.support.sehat.models.Address;
import com.life.support.sehat.models.Location;
import org.springframework.data.geo.Distance;

public interface LocationService {
    Address populateAddress(Location location);
    Distance getDistanceInBetween(Location locationA, Location locationB);
}
