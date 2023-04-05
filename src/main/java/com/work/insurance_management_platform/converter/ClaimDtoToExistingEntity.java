package com.work.insurance_management_platform.converter;

import com.work.insurance_management_platform.dto.ClaimDto;
import com.work.insurance_management_platform.entity.Claim;
import com.work.insurance_management_platform.entity.Client;
import com.work.insurance_management_platform.entity.InsurancePolicy;
import org.springframework.stereotype.Service;

@Service
public class ClaimDtoToExistingEntity {

    public Claim dtoToExistingEntity (ClaimDto claimDto, Claim claim) {

        if (claimDto.getClaimNumber() == null) {
            claim.setClaimNumber(claim.getClaimNumber());
        }

        if (claimDto.getDescription() == null) {
            claim.setDescription(claim.getDescription());
        }

        if (claimDto.getClaimDate() == null) {
            claim.setClaimDate(claim.getClaimDate());
        }

        if (claimDto.getClaimStatus() == null) {
            claim.setClaimStatus(claim.getClaimStatus());
        }

        if (claimDto.getPolicyId() == null) {
            InsurancePolicy policy = new InsurancePolicy();
            policy.setId(claim.getId());
            claim.setInsurancePolicy(policy);
        }

        claim.setClaimNumber(claimDto.getClaimNumber());
        claim.setDescription(claimDto.getDescription());
        claim.setClaimDate(claimDto.getClaimDate());
        claim.setClaimStatus(claimDto.getClaimStatus());

        InsurancePolicy policy = new InsurancePolicy();
        policy.setId(claimDto.getId());
        claim.setInsurancePolicy(policy);

        return claim;


    }
}
