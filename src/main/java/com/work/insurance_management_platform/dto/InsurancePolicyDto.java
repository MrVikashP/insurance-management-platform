package com.work.insurance_management_platform.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InsurancePolicyDto {
    private Long id;
    private String policyNumber;
    private String type;
    private BigDecimal coverageAmount;
    private BigDecimal premium;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long clientId;

}
