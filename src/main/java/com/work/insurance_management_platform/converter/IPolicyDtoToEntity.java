package com.work.insurance_management_platform.converter;


import com.work.insurance_management_platform.dto.InsurancePolicyDto;
import com.work.insurance_management_platform.entity.Client;
import com.work.insurance_management_platform.entity.InsurancePolicy;
import org.springframework.stereotype.Service;

@Service
public class IPolicyDtoToEntity {

    public InsurancePolicy dtoToEntity (InsurancePolicyDto insurancePolicyDto) {

        InsurancePolicy policy = new InsurancePolicy();
        policy.setId(insurancePolicyDto.getId());
        policy.setPolicyNumber(insurancePolicyDto.getPolicyNumber());
        policy.setType(insurancePolicyDto.getType());
        policy.setCoverageAmount(insurancePolicyDto.getCoverageAmount());
        policy.setPremium(insurancePolicyDto.getPremium());
        policy.setStartDate(insurancePolicyDto.getStartDate());
        policy.setEndDate(insurancePolicyDto.getEndDate());
        Client client = new Client();
        client.setId(insurancePolicyDto.getClientId());
        policy.setClient(client);
        return policy;
    }
}
