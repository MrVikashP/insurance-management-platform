package com.work.insurance_management_platform.controller;

import com.work.insurance_management_platform.dto.InsurancePolicyDto;
import com.work.insurance_management_platform.exception.InsuranceManagementServiceException;
import com.work.insurance_management_platform.service.InsurancePolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping("policies")
public class InsurancePolicyController {
    @Autowired
    InsurancePolicyService policyService;

    //  Fetch all policies
    @GetMapping("/fetchPolicies")
    public List<InsurancePolicyDto> fetchAllPolicies() throws Exception {
        List<InsurancePolicyDto> policyRecords = policyService.fetchAllPolicies();

        return policyRecords;
    }

    // Fetch a specific policy by ID
    @GetMapping("/fetchPolicy/{id}")
    public ResponseEntity<InsurancePolicyDto> fetchPolicyById(@PathVariable Long id) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        InsurancePolicyDto specificPolicy = policyService.fetchPolicyById(id);
        return ResponseEntity.ok(specificPolicy);

    }

    // Create a new policy
    @PostMapping("/createPolicies")
    public ResponseEntity<InsurancePolicyDto> createPolicies (@Validated @RequestBody InsurancePolicyDto policyDto) throws Exception {
        InsurancePolicyDto newPolicies = policyService.createPolicies(policyDto);

        return ResponseEntity.ok(newPolicies);

    }

    // Update a policy's information
    @PutMapping("/updatePolicies/{id}")
    public ResponseEntity<InsurancePolicyDto> updatePolicies (@PathVariable Long id, @Validated @RequestBody InsurancePolicyDto policyDto) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        policyDto.setId(id);

        InsurancePolicyDto updatedPolicies = policyService.updatePolicies(policyDto);

        return ResponseEntity.ok(updatedPolicies);

    }


    // Delete a policy
    @DeleteMapping("/deletePolicies/{id}")
    public ResponseEntity<InsurancePolicyDto> deletePolicy (@PathVariable Long id) throws Exception {
        if (isNull(id) || id <= 0) {
            throw new InsuranceManagementServiceException("Id should be present with proper positive value");
        }

        InsurancePolicyDto deletedPolicies = policyService.deletePolicies(id);

        return ResponseEntity.ok(deletedPolicies);

    }
}
