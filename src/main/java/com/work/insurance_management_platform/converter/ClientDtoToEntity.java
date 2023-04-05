package com.work.insurance_management_platform.converter;

import com.work.insurance_management_platform.dto.ClientDto;
import com.work.insurance_management_platform.entity.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientDtoToEntity {

    public Client dtoToEntity (ClientDto clientDto) {

        return Client.builder()
                .id(clientDto.getId())
                .name(clientDto.getName())
                .dateOfBirth(clientDto.getDateOfBirth())
                .address(clientDto.getAddress())
                .contactNumber(clientDto.getContactNumber())
                .build();
    }
}
