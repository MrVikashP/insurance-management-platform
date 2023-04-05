package com.work.insurance_management_platform.converter;

import com.work.insurance_management_platform.dto.ClientDto;
import com.work.insurance_management_platform.entity.Client;
import org.springframework.stereotype.Service;
import static java.util.Objects.isNull;

@Service
public class ClientDtoToExistingEntity {

    public Client dtoToExistingEntity (ClientDto clientDto, Client client) {
        if (isNull(clientDto.getName())) {
            client.setName(client.getName());
        }

        if (isNull(clientDto.getAddress())) {
            client.setAddress(client.getAddress());
        }

        if (isNull(clientDto.getDateOfBirth())) {
            client.setDateOfBirth(client.getDateOfBirth());
        }

        if (isNull(clientDto.getContactNumber())) {
            client.setContactNumber(client.getContactNumber());
        }

        client.setName(clientDto.getName());
        client.setDateOfBirth(clientDto.getDateOfBirth());
        client.setAddress(clientDto.getAddress());
        client.setContactNumber(clientDto.getContactNumber());

        return client;
    }
}
