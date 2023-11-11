package com.fernando.microservice.ClientModuleService.rest.Controller;

import com.fernando.microservice.ClientModuleService.domain.Client;
import com.fernando.microservice.ClientModuleService.repository.ClientRepository;
import com.fernando.microservice.ClientModuleService.rest.dto.ClientDTO;
import com.fernando.microservice.ClientModuleService.service.ClientService;
import com.fernando.microservice.ClientModuleService.utils.BadRequestAlertException;

import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClientController {
    private static final String ENTITY_NAME = "Client";

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO) throws URISyntaxException {

        ClientDTO result = clientService.save(clientDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClientDTO> read(@PathVariable Long id) {
        Optional<ClientDTO> clientDTO = clientService.findOne(id);
        return clientDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/clientes")
    public Page<ClientDTO> readAll(Pageable pageable) {
        return clientService.findAll(pageable);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClientDTO> update(
            @PathVariable Long id,
            @RequestBody ClientDTO clientDTO) throws URISyntaxException {

        if (clientDTO.getClientId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, clientDTO.getClientId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!clientRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }

        ClientDTO result = clientService.update(clientDTO);

        return ResponseEntity.ok().body(result);
    }

    @PatchMapping(value = "/clientes/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ClientDTO> updatePatch(@PathVariable Long id, @RequestBody ClientDTO clientDTO)
            throws URISyntaxException {
        if (clientDTO.getClientId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, clientDTO.getClientId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!clientRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }

        Optional<ClientDTO> result = clientService.partialUpdate(clientDTO);

        return ResponseEntity.ok().body(result.get());
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
