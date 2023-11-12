package com.fernando.microservice.AccountModuleService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.microservice.AccountModuleService.domain.Account;
import com.fernando.microservice.AccountModuleService.domain.Movement;
import com.fernando.microservice.AccountModuleService.repository.AccountRepository;
import com.fernando.microservice.AccountModuleService.repository.MovementRepository;
import com.fernando.microservice.AccountModuleService.rest.Mapper.MovementMapper;
import com.fernando.microservice.AccountModuleService.rest.dto.MovementDTO;

import com.fernando.microservice.AccountModuleService.utils.BadRequestAlertException;

import java.util.Optional;

@Service
public class MovementService {
    private final MovementMapper movementMapper;
    private final MovementRepository movementRepository;
    private final AccountRepository accountRepository;

    public MovementService(MovementMapper movementMapper, MovementRepository movementRepository,
            AccountRepository accountRepository) {
        this.movementMapper = movementMapper;
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
    }

    public MovementDTO save(MovementDTO movementDTO) {
        Optional<Account> account = accountRepository.findById(movementDTO.getCuenta().getId());

        if (account.isEmpty()) {
            throw new BadRequestAlertException("La cuenta no existe");
        }

        Movement movement = movementMapper.toEntity(movementDTO);

        Movement lastMovement = movementRepository.findTopByOrderByIdDesc();

        if (lastMovement == null) {
            if (account.get().getSaldoInicial() != null) {
                Movement initialDeposit = new Movement();
                initialDeposit.setCuenta(account.get());
                initialDeposit.setMovimiento("Deposito");
                initialDeposit.setValor(account.get().getSaldoInicial());
                initialDeposit.setSaldo(account.get().getSaldoInicial());
                initialDeposit.setTipo(account.get().getTipoCuenta());
                initialDeposit.setFecha(movement.getFecha());
                movementRepository.save(initialDeposit);

                movement.setSaldo(account.get().getSaldoInicial());
            } else {

                throw new BadRequestAlertException("No se puede crear el primer movimiento sin saldo inicial");
            }
        } else {
            movement.setSaldo(lastMovement.getSaldo());
        }

        Double newBalance = movement.getSaldo();

        if (movement.getMovimiento().equals("Retiro")) {
            if (newBalance < movement.getValor()) {
                throw new BadRequestAlertException("Saldo no disponible");
            }
            newBalance -= movement.getValor();
        }

        if (movement.getMovimiento().equals("Deposito")) {
            newBalance += movement.getValor();
        }

        movement.setSaldo(newBalance);

        movement = movementRepository.save(movement);

        return movementMapper.toDto(movement);
    }

    @Transactional(readOnly = true)
    public Optional<MovementDTO> findOne(Long id) {
        return movementRepository.findById(id).map(movementMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<MovementDTO> findAll(Pageable pageable) {
        return movementRepository.findAll(pageable).map(movementMapper::toDto);
    }

    public MovementDTO update(MovementDTO movementDTO) {

        Movement movement = movementMapper.toEntity(movementDTO);
        movement = movementRepository.saveAndFlush(movement);
        return movementMapper.toDto(movement);
    }

    public Optional<MovementDTO> partialUpdate(MovementDTO movementDTO) {

        return movementRepository
                .findById(movementDTO.getId())
                .map(existingmovement -> {
                    movementMapper.partialUpdate(existingmovement, movementDTO);
                    movementRepository.saveAndFlush(existingmovement);
                    return existingmovement;
                })
                .map(movementRepository::save)
                .map(movementMapper::toDto);
    }

    public void delete(Long id) {
        movementRepository.deleteById(id);
    }

}
