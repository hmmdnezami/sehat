package com.life.support.sehat.repository;

import com.life.support.sehat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<User, Long> {
}
