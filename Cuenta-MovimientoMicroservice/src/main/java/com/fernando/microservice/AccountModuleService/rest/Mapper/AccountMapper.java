package com.fernando.microservice.AccountModuleService.rest.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.fernando.microservice.AccountModuleService.domain.Account;
import com.fernando.microservice.AccountModuleService.rest.dto.AccountDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper extends EntityMapper<AccountDTO, Account> {
}
