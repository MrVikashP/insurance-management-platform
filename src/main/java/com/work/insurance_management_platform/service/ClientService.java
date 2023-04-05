package com.work.insurance_management_platform.service;

import com.work.insurance_management_platform.converter.ClientDtoToEntity;
import com.work.insurance_management_platform.converter.ClientDtoToExistingEntity;
import com.work.insurance_management_platform.converter.ClientEntityToDto;
import com.work.insurance_management_platform.dto.ClientDto;
import com.work.insurance_management_platform.entity.Client;
import com.work.insurance_management_platform.exception.InsuranceManagementServiceException;
import com.work.insurance_management_platform.repository.ClientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    ClientEntityToDto clientEntityToDto;
    @Autowired
    ClientDtoToEntity clientDtoToEntity;
    @Autowired
    ClientDtoToExistingEntity clientDtoToExistingEntity;


    //  Fetch all clients - Service
    public List<ClientDto> fetchAllClients () throws Exception {
        log.info("Fetching records of all clients");
        List<Client> clients = clientRepo.findAll();

        if (clients.isEmpty()) {
            throw new InsuranceManagementServiceException("Not a single client available");
        }

        List<ClientDto> clientDtos = clientEntityToDto.entityToDto(clients);
        return clientDtos;
    }

    // Fetch a specific client by ID - Service
    public ClientDto fetchClientById (Long id) throws Exception {
        log.info("Fetching specific client by id");
        Client client = clientRepo.findClientById(id);

        if (client == null) {
            throw new InsuranceManagementServiceException("No record found of client with id :" + id);
        }

        ClientDto clientDto = clientEntityToDto.entityToDto(client);

        return clientDto;

    }

    // Create a new client - Service
    public ClientDto createClients (ClientDto clientDto) throws Exception {
        log.info("Creating a client, wow !");
        checkForNullInputs(clientDto);

        Client client = clientDtoToEntity.dtoToEntity(clientDto);
        clientRepo.save(client);

        ClientDto newClient = clientEntityToDto.entityToDto(client);

        return newClient;
    }

    // Update a client's information - Service
    public ClientDto updateClients (ClientDto clientDto) throws Exception {
        log.info("updating existing client");
        if (clientDto == null) {
            throw new InsuranceManagementServiceException("EveryThing can't be null, provide some values");
        }

        Client existingClient = clientRepo.findClientById(clientDto.getId());
        if (existingClient == null) {
            throw new InsuranceManagementServiceException("Existing client is not found whom to update");
        }

        Client client = clientDtoToExistingEntity.dtoToExistingEntity(clientDto, existingClient);
        clientRepo.save(client);

        ClientDto updatedClient = clientEntityToDto.entityToDto(client);
        return updatedClient;
    }

    // Delete a client - Service
    public ClientDto deleteClients (Long id) throws Exception {
        log.info("deleting client that exists");
        Client client = clientRepo.findClientById(id);

        if (client == null) {
            log.info("No existing client");
            throw new InsuranceManagementServiceException("No record found that already exists");
        }

        clientRepo.delete(client);

        return clientEntityToDto.entityToDto(client);
    }

    // checking for null inputs - creating a client
    private void checkForNullInputs(ClientDto clientDto) {

        if(isNull(clientDto.getDateOfBirth())){
            throw new InsuranceManagementServiceException("DOB can`t be empty");
        }
        if(isNull(clientDto.getName())){
            throw new InsuranceManagementServiceException("Name can`t be empty");
        }
        if (isNull(clientDto.getContactNumber())){
            throw new InsuranceManagementServiceException("Contact number can`t be empty");
        }

        if (isNull(clientDto.getAddress())) {
            throw new InsuranceManagementServiceException("Address can't be empty");
        }

    }
}
