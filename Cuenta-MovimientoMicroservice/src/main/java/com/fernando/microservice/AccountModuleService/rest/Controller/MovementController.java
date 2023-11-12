package com.fernando.microservice.AccountModuleService.rest.Controller;

import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.fernando.microservice.AccountModuleService.repository.MovementRepository;
import com.fernando.microservice.AccountModuleService.rest.dto.MovementDTO;
import com.fernando.microservice.AccountModuleService.service.MovementService;
import com.fernando.microservice.AccountModuleService.utils.BadRequestAlertException;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MovementController {

    private final MovementService movementService;
    private final MovementRepository movementRepository;

    public MovementController(MovementService movementService, MovementRepository movementRepository) {
        this.movementService = movementService;
        this.movementRepository = movementRepository;
    }

    @PostMapping("/movimientos")
    public ResponseEntity<MovementDTO> create(@RequestBody MovementDTO movementDTO) throws URISyntaxException {
        if (movementDTO.getId() != null) {
            throw new BadRequestAlertException("Id debe ser nulo");
        }
        if (movementDTO.getCuenta() == null) {
            throw new BadRequestAlertException("La cuenta no puede ser nula");
        }

        MovementDTO result = movementService.save(movementDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/movimientos/{id}")
    public ResponseEntity<MovementDTO> read(@PathVariable Long id) {
        Optional<MovementDTO> movementDTO = movementService.findOne(id);
        return movementDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/movimientos")
    public Page<MovementDTO> readAll(Pageable pageable) {
        return movementService.findAll(pageable);
    }

    @PutMapping("/movimientos/{id}")
    public ResponseEntity<MovementDTO> update(
            @PathVariable Long id,
            @RequestBody MovementDTO movementDTO) throws URISyntaxException {

        if (movementDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, movementDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!movementRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }

        MovementDTO result = movementService.update(movementDTO);

        return ResponseEntity.ok().body(result);
    }

    @PatchMapping(value = "/movimientos/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<MovementDTO> updatePatch(@PathVariable Long id, @RequestBody MovementDTO movementDTO)
            throws URISyntaxException {
        if (movementDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, movementDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!movementRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }

        Optional<MovementDTO> result = movementService.partialUpdate(movementDTO);

        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/movimientos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        movementService.delete(id);
        return ResponseEntity.ok().build();
    }
}
