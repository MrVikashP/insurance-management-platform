package com.work.insurance_management_platform.converter;


import com.work.insurance_management_platform.dto.ClaimDto;
import com.work.insurance_management_platform.entity.Claim;
import com.work.insurance_management_platform.entity.InsurancePolicy;
import org.springframework.stereotype.Service;

@Service
public class ClaimDtoToEntity {

    public Claim dtoToEntity(ClaimDto claimDTO) {
        Claim claim = new Claim();
        claim.setId(claimDTO.getId());
        claim.setClaimNumber(claimDTO.getClaimNumber());
        claim.setDescription(claimDTO.getDescription());
        claim.setClaimDate(claimDTO.getClaimDate());
        claim.setClaimStatus(claim.getClaimStatus());
        InsurancePolicy policy = new InsurancePolicy();
        policy.setId(claimDTO.getPolicyId());
        claim.setInsurancePolicy(policy);
        return claim;
    }

}
