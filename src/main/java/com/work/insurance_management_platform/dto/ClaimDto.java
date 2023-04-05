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
public class ClaimDto {
    private Long id;
    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private String claimStatus;
    private Long policyId;
}
