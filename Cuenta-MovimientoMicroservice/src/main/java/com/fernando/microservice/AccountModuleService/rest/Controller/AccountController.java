package com.fernando.microservice.AccountModuleService.rest.Controller;

import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.fernando.microservice.AccountModuleService.repository.AccountRepository;
import com.fernando.microservice.AccountModuleService.rest.dto.AccountDTO;
import com.fernando.microservice.AccountModuleService.service.AccountService;
import com.fernando.microservice.AccountModuleService.utils.BadRequestAlertException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;
    private final AccountRepository accountRepository;

    public AccountController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/cuentas")
    public ResponseEntity<AccountDTO> create(@RequestBody AccountDTO accountDTO) throws URISyntaxException {
        if (accountDTO.getId() != null) {
            throw new BadRequestAlertException("Id debe ser nulo");
        }
        if (accountDTO.getNumeroCuenta() == null) {
            throw new BadRequestAlertException("Numero de cuenta no puede ser nulo");
        }
        if (accountDTO.getTipoCuenta() == null) {
            throw new BadRequestAlertException("Tipo de cuenta no puede ser nulo");
        }
        if (accountDTO.getSaldoInicial() == null) {
            throw new BadRequestAlertException("Saldo inicial no puede ser nulo");
        }
        if (accountDTO.getClient() == null) {
            throw new BadRequestAlertException("Cliente no puede ser nulo");
        }

        AccountDTO result = accountService.save(accountDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/cuentas/{id}")
    public ResponseEntity<AccountDTO> read(@PathVariable Long id) {
        Optional<AccountDTO> accountDTO = accountService.findOne(id);
        return accountDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cuentas")
    public Page<AccountDTO> readAll(Pageable pageable) {
        return accountService.findAll(pageable);
    }

    @PutMapping("/cuentas/{id}")
    public ResponseEntity<AccountDTO> update(
            @PathVariable Long id,
            @RequestBody AccountDTO accountDTO) throws URISyntaxException {

        if (accountDTO.getId() == null) {
            throw new BadRequestAlertException("id debe ser nulo");
        }
        if (!Objects.equals(id, accountDTO.getId())) {
            throw new BadRequestAlertException("id debe ser nulo");
        }
        if (!accountRepository.existsById(id)) {
            throw new BadRequestAlertException("entidad no encontrada");
        }
        if (accountDTO.getNumeroCuenta() == null) {
            throw new BadRequestAlertException("Numero de cuenta no puede ser nulo");
        }
        if (accountDTO.getTipoCuenta() == null) {
            throw new BadRequestAlertException("Tipo de cuenta no puede ser nulo");
        }
        if (accountDTO.getSaldoInicial() == null) {
            throw new BadRequestAlertException("Saldo inicial no puede ser nulo");
        }
        if (accountDTO.getEstado() == null) {
            throw new BadRequestAlertException("Estado no puede ser nulo");
        }

        AccountDTO result = accountService.update(accountDTO);

        return ResponseEntity.ok().body(result);
    }

    @PatchMapping(value = "/cuentas/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<AccountDTO> updatePatch(@PathVariable Long id, @RequestBody AccountDTO accountDTO)
            throws URISyntaxException {
        if (accountDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, accountDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!accountRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }

        Optional<AccountDTO> result = accountService.partialUpdate(accountDTO);

        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/cuentas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        accountService.delete(id);
        return ResponseEntity.ok().build();
    }
}
