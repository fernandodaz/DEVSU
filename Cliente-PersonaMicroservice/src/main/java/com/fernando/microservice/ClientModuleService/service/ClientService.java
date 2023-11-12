package com.fernando.microservice.ClientModuleService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando.microservice.ClientModuleService.repository.ClientRepository;
import com.fernando.microservice.ClientModuleService.domain.Client;
import com.fernando.microservice.ClientModuleService.rest.Mapper.ClientMapper;
import com.fernando.microservice.ClientModuleService.rest.dto.ClientDTO;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    public ClientService(ClientMapper clientMapper, ClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }

    public ClientDTO save(ClientDTO clientDTO) {

        Client client = clientMapper.toEntity(clientDTO);

        client = clientRepository.save(client);

        return clientMapper.toDto(client);
    }

    @Transactional(readOnly = true)
    public Optional<ClientDTO> findOne(Long id) {
        return clientRepository.findById(id).map(clientMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable).map(clientMapper::toDto);
    }

    public ClientDTO update(ClientDTO clientDTO) {

        Client client = clientMapper.toEntity(clientDTO);
        client = clientRepository.saveAndFlush(client);
        return clientMapper.toDto(client);
    }

    public Optional<ClientDTO> partialUpdate(ClientDTO clientDTO) {

        return clientRepository
                .findById(clientDTO.getClientId())
                .map(existingclient -> {
                    clientMapper.partialUpdate(existingclient, clientDTO);
                    clientRepository.saveAndFlush(existingclient);
                    return existingclient;
                })
                .map(clientRepository::save)
                .map(clientMapper::toDto);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
