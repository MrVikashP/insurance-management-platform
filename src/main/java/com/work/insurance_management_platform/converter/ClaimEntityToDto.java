package com.work.insurance_management_platform.converter;

import com.work.insurance_management_platform.dto.ClaimDto;
import com.work.insurance_management_platform.entity.Claim;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Service
public class ClaimEntityToDto {

    public ClaimDto entityToDto (Claim claim) {

        if (isNull(claim)) {
            return ClaimDto.builder().build();
        }

        return ClaimDto.builder()
                .id(claim.getId())
                .claimNumber(claim.getClaimNumber())
                .description(claim.getDescription())
                .claimDate(claim.getClaimDate())
                .claimStatus(claim.getClaimStatus())
                .policyId(claim.getInsurancePolicy().getId())
                .build();
    }

    public List<ClaimDto> entityToDto (List<Claim> claims) {
        return claims.stream().map(this::entityToDto).collect(Collectors.toList());
    }

}
