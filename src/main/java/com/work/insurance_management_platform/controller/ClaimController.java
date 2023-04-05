package com.work.insurance_management_platform.controller;

import com.work.insurance_management_platform.dto.ClaimDto;
import com.work.insurance_management_platform.exception.InsuranceManagementServiceException;
import com.work.insurance_management_platform.service.ClaimService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping("claims")
public class ClaimController {
    @Autowired
    ClaimService claimService;

    //  Fetch all claims
    @GetMapping("/fetchClaims")
    public List<ClaimDto> fetchAllClaims() throws Exception {
        List<ClaimDto> claimRecords = claimService.fetchAllClaims();

        return claimRecords;
    }

    // Fetch a specific claims by ID
    @GetMapping("/fetchClaim/{id}")
    public ResponseEntity<ClaimDto> fetchClaimById(@PathVariable Long id) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        ClaimDto specificClaim = claimService.fetchClaimById(id);

        return ResponseEntity.ok(specificClaim);

    }

    // Create a new claim
    @PostMapping("/createClaims")
    public ResponseEntity<ClaimDto> createClaims (@Validated @RequestBody ClaimDto claimDto) throws Exception {
        ClaimDto newClaims = claimService.createClaims(claimDto);

        return ResponseEntity.ok(newClaims);

    }

    // Update a claim's information
    @PutMapping("/updateClaims/{id}")
    public ResponseEntity<ClaimDto> updateClaims (@PathVariable Long id, @Validated @RequestBody ClaimDto claimDto) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        claimDto.setId(id);

        ClaimDto updatedClaim = claimService.updateClaim(claimDto);

        return ResponseEntity.ok(updatedClaim);

    }


    // Delete a claim
    @DeleteMapping("/deleteClaims/{id}")
    public ResponseEntity<ClaimDto> deleteClaim (@PathVariable Long id) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        ClaimDto deletedClaim = claimService.deleteClaim(id);

        return ResponseEntity.ok(deletedClaim);
    }
}
