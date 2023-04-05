package com.work.insurance_management_platform.controller;

import com.work.insurance_management_platform.dto.ClientDto;
import com.work.insurance_management_platform.exception.InsuranceManagementServiceException;
import com.work.insurance_management_platform.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    //  Fetch all clients
    @GetMapping("/fetchClients")
    public List<ClientDto> fetchAllClients() throws Exception {
        List<ClientDto> clientRecords = clientService.fetchAllClients();

        return clientRecords;
    }

    // Fetch a specific client by ID
    @GetMapping("/fetchClient/{id}")
    public ResponseEntity<ClientDto> fetchClientById(@PathVariable Long id) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        ClientDto specificClient = clientService.fetchClientById(id);

        return ResponseEntity.ok(specificClient);


    }

    // Create a new client
    @PostMapping("/createClients")
    public ResponseEntity<ClientDto> createClients (@Validated @RequestBody ClientDto clientDto) throws Exception {
        ClientDto newClients = clientService.createClients(clientDto);

        return ResponseEntity.ok(newClients);

    }

    // Update a client's information
    @PutMapping("/updateClients/{id}")
    public ResponseEntity<ClientDto> updateClients (@PathVariable Long id, @Validated @RequestBody ClientDto clientDto) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        clientDto.setId(id);

        ClientDto updatedClient = clientService.updateClients(clientDto);

        return ResponseEntity.ok(updatedClient);
    }


    // Delete a client
    @DeleteMapping("/deleteClients/{id}")
    public ResponseEntity<ClientDto> deleteClient (@PathVariable Long id) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        ClientDto deletedClient = clientService.deleteClients(id);

        return ResponseEntity.ok(deletedClient);

    }










}
