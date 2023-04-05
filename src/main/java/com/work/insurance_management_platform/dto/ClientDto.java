package com.work.insurance_management_platform.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDto {

    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private String contactNumber;

}
