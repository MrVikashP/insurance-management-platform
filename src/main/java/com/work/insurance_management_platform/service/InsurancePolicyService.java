package com.work.insurance_management_platform.service;

import com.work.insurance_management_platform.converter.IPolicyDtoToEntity;
import com.work.insurance_management_platform.converter.IPolicyDtoToExistingEntity;
import com.work.insurance_management_platform.converter.IPolicyEntityToDto;
import com.work.insurance_management_platform.dto.InsurancePolicyDto;
import com.work.insurance_management_platform.entity.InsurancePolicy;
import com.work.insurance_management_platform.exception.InsuranceManagementServiceException;
import com.work.insurance_management_platform.repository.InsurancePolicyRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static java.util.Objects.isNull;

@Slf4j
@Service
public class InsurancePolicyService {
    @Autowired
    InsurancePolicyRepo policyRepo;
    @Autowired
    IPolicyEntityToDto policyEntityToDto;
    @Autowired
    IPolicyDtoToEntity policyDtoToEntity;
    @Autowired
    IPolicyDtoToExistingEntity policyDtoToExistingEntity;

    //  Fetch all insurance policies - Service
    public List<InsurancePolicyDto> fetchAllPolicies () throws Exception {
        log.info("Fetching records of all policies");
        List<InsurancePolicy> policies = policyRepo.findAll();

        if (policies.isEmpty()) {
            throw new InsuranceManagementServiceException("Not a single policy available");
        }

        List<InsurancePolicyDto> insurancePolicyDtos = policyEntityToDto.entityToDto(policies);
        return insurancePolicyDtos;
    }

    // Fetch a specific policy by ID - Service
    public InsurancePolicyDto fetchPolicyById (Long id) throws Exception {
        log.info("Fetching specific policy by id");
        InsurancePolicy policy = policyRepo.findInsurancePolicyById(id);

        if (policy == null) {
            throw new InsuranceManagementServiceException("No record found of policy with id :" + id);
        }

        InsurancePolicyDto insurancePolicyDto = policyEntityToDto.entityToDto(policy);

        return insurancePolicyDto;

    }

    // Create a new policy - Service
    public InsurancePolicyDto createPolicies (InsurancePolicyDto policyDto) throws Exception {
        log.info("Creating a policy, wow !");
        checkForNullInputs(policyDto);

        InsurancePolicy policy = policyDtoToEntity.dtoToEntity(policyDto);
        policyRepo.save(policy);

        InsurancePolicyDto newPolicy = policyEntityToDto.entityToDto(policy);

        return newPolicy;
    }

    // Update a policy's information - Service
    public InsurancePolicyDto updatePolicies (InsurancePolicyDto policyDto) throws Exception {
        log.info("updating existing policy");
        if (policyDto == null) {
            throw new InsuranceManagementServiceException("EveryThing can't be null, provide some values");
        }

        InsurancePolicy existingPolicy = policyRepo.findInsurancePolicyById(policyDto.getId());
        if (existingPolicy == null) {
            throw new InsuranceManagementServiceException("Existing policy is not found whom to update");
        }

        InsurancePolicy updatedPolicy = policyDtoToExistingEntity.dtoToExistingEntity(policyDto, existingPolicy);
        policyRepo.save(updatedPolicy);

        return policyEntityToDto.entityToDto(updatedPolicy);
    }

    // Delete a policy - Service
    public InsurancePolicyDto deletePolicies (Long id) throws Exception {
        log.info("deleting policy that exists");
        InsurancePolicy policy = policyRepo.findInsurancePolicyById(id);

        if (policy == null) {
            throw new InsuranceManagementServiceException("No record found that already exists");
        }

        policyRepo.delete(policy);

        return policyEntityToDto.entityToDto(policy);
    }

    // checking for null inputs - creating a policy
    private void checkForNullInputs(InsurancePolicyDto policyDto) {

        if(isNull(policyDto.getPolicyNumber())){
            throw new InsuranceManagementServiceException("Policy Number can`t be empty");
        }
        if(isNull(policyDto.getType())){
            throw new InsuranceManagementServiceException("Type can`t be empty");
        }
        if (isNull(policyDto.getCoverageAmount())){
            throw new InsuranceManagementServiceException("Coverage amount can`t be empty");
        }

        if (isNull(policyDto.getPremium())) {
            throw new InsuranceManagementServiceException("Premium can't be empty");
        }

        if (isNull(policyDto.getStartDate())) {
            throw new InsuranceManagementServiceException("Start date can't be empty");
        }

        if (isNull(policyDto.getEndDate())) {
            throw new InsuranceManagementServiceException("End date can't be empty");
        }

        if (isNull(policyDto.getClientId())) {
            throw new InsuranceManagementServiceException("Client id can't be empty");
        }

    }
}
