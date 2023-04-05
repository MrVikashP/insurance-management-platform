package com.work.insurance_management_platform.converter;

import com.work.insurance_management_platform.dto.InsurancePolicyDto;
import com.work.insurance_management_platform.entity.Client;
import com.work.insurance_management_platform.entity.InsurancePolicy;
import org.springframework.stereotype.Service;

@Service
public class IPolicyDtoToExistingEntity {

    public InsurancePolicy dtoToExistingEntity (InsurancePolicyDto policyDto, InsurancePolicy policy) {

        if (policyDto.getPolicyNumber() == null) {
            policy.setPolicyNumber(policy.getPolicyNumber());
        }

        if (policyDto.getType() == null) {
            policy.setType(policy.getType());
        }

        if (policyDto.getCoverageAmount() == null) {
            policy.setCoverageAmount(policy.getCoverageAmount());
        }

        if (policyDto.getPremium() == null) {
            policy.setPremium(policy.getPremium());
        }

        if (policyDto.getStartDate() == null) {
            policy.setStartDate(policy.getStartDate());
        }

        if (policyDto.getEndDate() == null) {
            policy.setEndDate(policy.getEndDate());
        }

        if (policyDto.getClientId() == null) {
            Client client = new Client();
            client.setId(policy.getId());
            policy.setClient(client);
        }

        policy.setPolicyNumber(policyDto.getPolicyNumber());
        policy.setType(policyDto.getType());
        policy.setCoverageAmount(policyDto.getCoverageAmount());
        policy.setPremium(policyDto.getPremium());
        policy.setStartDate(policyDto.getStartDate());
        policy.setEndDate(policyDto.getEndDate());
        Client client = new Client();
        client.setId(policyDto.getClientId());
        policy.setClient(client);

        return policy;
    }
}
