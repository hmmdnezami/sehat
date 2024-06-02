package com.life.support.sehat.repository;

import com.life.support.sehat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
