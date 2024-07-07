package com.life.support.sehat.repository;

import com.life.support.sehat.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    Booking findTop1ByUserIdOrderByCreatedAtDesc(long userId);
    Booking findTop1ByDriverIdOrderByCreatedAtDesc(long userId);
    List<Booking> findByUserIdOrderByCreatedAtDesc(long userId);
    List<Booking> findByDriverIdOrderByCreatedAtDesc(long userId);
}
