package com.fernando.microservice.AccountModuleService.rest.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.fernando.microservice.AccountModuleService.domain.Movement;
import com.fernando.microservice.AccountModuleService.rest.dto.MovementDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovementMapper extends EntityMapper<MovementDTO, Movement> {
}
