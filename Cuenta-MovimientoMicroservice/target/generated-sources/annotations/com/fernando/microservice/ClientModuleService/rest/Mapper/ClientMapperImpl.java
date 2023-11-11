package com.fernando.microservice.ClientModuleService.rest.Mapper;

import com.fernando.microservice.ClientModuleService.domain.Client;
import com.fernando.microservice.ClientModuleService.domain.Person;
import com.fernando.microservice.ClientModuleService.rest.dto.ClientDTO;
import com.fernando.microservice.ClientModuleService.rest.dto.PersonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-11T17:22:22-0400",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.8.1 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Client client = new Client();

        client.setClientId( dto.getClientId() );
        client.setPassword( dto.getPassword() );
        client.setStatus( dto.getStatus() );
        client.setPerson( personDTOToPerson( dto.getPerson() ) );

        return client;
    }

    @Override
    public ClientDTO toDto(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setClientId( entity.getClientId() );
        clientDTO.setPassword( entity.getPassword() );
        clientDTO.setStatus( entity.getStatus() );
        clientDTO.setPerson( personToPersonDTO( entity.getPerson() ) );

        return clientDTO;
    }

    @Override
    public List<Client> toEntity(List<ClientDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Client> list = new ArrayList<Client>( dtoList.size() );
        for ( ClientDTO clientDTO : dtoList ) {
            list.add( toEntity( clientDTO ) );
        }

        return list;
    }

    @Override
    public List<ClientDTO> toDto(List<Client> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( entityList.size() );
        for ( Client client : entityList ) {
            list.add( toDto( client ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Client entity, ClientDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getClientId() != null ) {
            entity.setClientId( dto.getClientId() );
        }
        if ( dto.getPassword() != null ) {
            entity.setPassword( dto.getPassword() );
        }
        if ( dto.getStatus() != null ) {
            entity.setStatus( dto.getStatus() );
        }
        if ( dto.getPerson() != null ) {
            if ( entity.getPerson() == null ) {
                entity.setPerson( new Person() );
            }
            personDTOToPerson1( dto.getPerson(), entity.getPerson() );
        }
    }

    protected Person personDTOToPerson(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( personDTO.getId() );
        person.setName( personDTO.getName() );
        person.setGender( personDTO.getGender() );
        person.setAge( personDTO.getAge() );
        person.setIdentification( personDTO.getIdentification() );
        person.setAddress( personDTO.getAddress() );
        person.setPhone( personDTO.getPhone() );

        return person;
    }

    protected PersonDTO personToPersonDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setName( person.getName() );
        personDTO.setGender( person.getGender() );
        personDTO.setAge( person.getAge() );
        personDTO.setIdentification( person.getIdentification() );
        personDTO.setAddress( person.getAddress() );
        personDTO.setPhone( person.getPhone() );

        return personDTO;
    }

    protected void personDTOToPerson1(PersonDTO personDTO, Person mappingTarget) {
        if ( personDTO == null ) {
            return;
        }

        mappingTarget.setId( personDTO.getId() );
        mappingTarget.setName( personDTO.getName() );
        mappingTarget.setGender( personDTO.getGender() );
        mappingTarget.setAge( personDTO.getAge() );
        mappingTarget.setIdentification( personDTO.getIdentification() );
        mappingTarget.setAddress( personDTO.getAddress() );
        mappingTarget.setPhone( personDTO.getPhone() );
    }
}
