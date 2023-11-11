package com.fernando.microservice.ClientModuleService.rest.Mapper;

import com.fernando.microservice.ClientModuleService.domain.Client;
import com.fernando.microservice.ClientModuleService.rest.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper extends EntityMapper<ClientDTO, Client> {}
