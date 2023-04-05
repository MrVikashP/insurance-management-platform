package com.work.insurance_management_platform.converter;

import com.work.insurance_management_platform.dto.InsurancePolicyDto;
import com.work.insurance_management_platform.entity.InsurancePolicy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Service
public class IPolicyEntityToDto {

    public InsurancePolicyDto entityToDto (InsurancePolicy insurancePolicy) {

        if (isNull(insurancePolicy)) {
            return InsurancePolicyDto.builder().build();
        }

        return InsurancePolicyDto.builder()
                .id(insurancePolicy.getId())
                .policyNumber(insurancePolicy.getPolicyNumber())
                .type(insurancePolicy.getType())
                .coverageAmount(insurancePolicy.getCoverageAmount())
                .premium(insurancePolicy.getPremium())
                .startDate(insurancePolicy.getStartDate())
                .endDate(insurancePolicy.getEndDate())
                .clientId(insurancePolicy.getClient().getId())
                .build();
    }

    public List<InsurancePolicyDto> entityToDto (List<InsurancePolicy> insurancePolicies) {
        return insurancePolicies.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
