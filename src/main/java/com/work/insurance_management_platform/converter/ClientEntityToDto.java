package com.work.insurance_management_platform.converter;

import com.work.insurance_management_platform.dto.ClientDto;
import com.work.insurance_management_platform.entity.Client;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Service
public class ClientEntityToDto {

    public ClientDto entityToDto (Client client) {
        if (isNull(client)) {
            return ClientDto.builder().build();
        }

        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .dateOfBirth(client.getDateOfBirth())
                .address(client.getAddress())
                .contactNumber(client.getContactNumber())
                .build();

    }

    public List<ClientDto> entityToDto(List<Client> clients) {
        return clients.stream().map(this::entityToDto).collect(Collectors.toList());

    }

//    public ClientDto entityToDto(Optional<Client> client) {
//        return
//    }
}
