package com.fernando.microservice.AccountModuleService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.microservice.AccountModuleService.domain.Account;
import com.fernando.microservice.AccountModuleService.repository.AccountRepository;
import com.fernando.microservice.AccountModuleService.rest.Mapper.AccountMapper;
import com.fernando.microservice.AccountModuleService.rest.dto.AccountDTO;
import com.fernando.microservice.AccountModuleService.utils.BadRequestAlertException;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public AccountService(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    public AccountDTO save(AccountDTO accountDTO) {

        if (accountRepository.existsByNumeroCuenta(accountDTO.getNumeroCuenta())) {
            throw new BadRequestAlertException("El numero de cuenta ya existe");
        }
        Account account = accountMapper.toEntity(accountDTO);

        account = accountRepository.save(account);

        return accountMapper.toDto(account);
    }

    @Transactional(readOnly = true)
    public Optional<AccountDTO> findOne(Long id) {
        return accountRepository.findById(id).map(accountMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<AccountDTO> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable).map(accountMapper::toDto);
    }

    public AccountDTO update(AccountDTO accountDTO) {

        Account account = accountMapper.toEntity(accountDTO);
        account = accountRepository.saveAndFlush(account);
        return accountMapper.toDto(account);
    }

    public Optional<AccountDTO> partialUpdate(AccountDTO accountDTO) {

        return accountRepository
                .findById(accountDTO.getId())
                .map(existingaccount -> {
                    accountMapper.partialUpdate(existingaccount, accountDTO);
                    accountRepository.saveAndFlush(existingaccount);
                    return existingaccount;
                })
                .map(accountRepository::save)
                .map(accountMapper::toDto);
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

}
