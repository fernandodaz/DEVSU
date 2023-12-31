package com.fernando.microservice.ClientModuleService.repository;

import com.fernando.microservice.ClientModuleService.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
