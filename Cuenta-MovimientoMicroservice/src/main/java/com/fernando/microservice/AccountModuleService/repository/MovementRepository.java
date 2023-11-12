package com.fernando.microservice.AccountModuleService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.microservice.AccountModuleService.domain.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
    Movement findTopByOrderByIdDesc();
}
