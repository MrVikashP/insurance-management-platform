package com.work.insurance_management_platform.service;

import com.work.insurance_management_platform.converter.ClaimDtoToEntity;
import com.work.insurance_management_platform.converter.ClaimDtoToExistingEntity;
import com.work.insurance_management_platform.converter.ClaimEntityToDto;
import com.work.insurance_management_platform.dto.ClaimDto;
import com.work.insurance_management_platform.entity.Claim;
import com.work.insurance_management_platform.exception.InsuranceManagementServiceException;
import com.work.insurance_management_platform.repository.ClaimRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class ClaimService {
    @Autowired
    ClaimRepo claimRepo;
    @Autowired
    ClaimEntityToDto claimEntityToDto;
    @Autowired
    ClaimDtoToEntity claimDtoToEntity;
    @Autowired
    ClaimDtoToExistingEntity claimDtoToExistingEntity;

    //  Fetch all claims - Service
    public List<ClaimDto> fetchAllClaims () throws Exception {
        log.info("Fetching records of all claims");
        List<Claim> claims = claimRepo.findAll();

        if (claims.isEmpty()) {
            throw new InsuranceManagementServiceException("Not a single claim available");
        }

        List<ClaimDto> claimDtos = claimEntityToDto.entityToDto(claims);
        return claimDtos;
    }

    // Fetch a specific claim by ID - Service
    public ClaimDto fetchClaimById (Long id) throws Exception {
        log.info("Fetching specific claim by id");
        Claim claim = claimRepo.findClaimById(id);

        if (claim == null) {
            throw new InsuranceManagementServiceException("No record found of claim with id :" + id);
        }

        return claimEntityToDto.entityToDto(claim);
    }

    // Create a new claim - Service
    public ClaimDto createClaims (ClaimDto claimDto) throws Exception {
        log.info("Creating a claim, wow !");
        checkForNullInputs(claimDto);

        Claim claim = claimDtoToEntity.dtoToEntity(claimDto);
        claimRepo.save(claim);

        return claimEntityToDto.entityToDto(claim);
    }

    // Update a claim's information - Service
    public ClaimDto updateClaim (ClaimDto claimDto) throws Exception {
        log.info("updating existing claim");
        if (claimDto == null) {
            throw new InsuranceManagementServiceException("EveryThing can't be null, provide some values");
        }

        Claim existingClaim = claimRepo.findClaimById(claimDto.getId());
        if (existingClaim == null) {
            throw new InsuranceManagementServiceException("Existing claim is not found whom to update");
        }

        Claim updatedClaim = claimDtoToExistingEntity.dtoToExistingEntity(claimDto, existingClaim);
        claimRepo.save(updatedClaim);

        return claimEntityToDto.entityToDto(updatedClaim);
    }

    // Delete a claim - Service
    public ClaimDto deleteClaim (Long id) throws Exception {
        log.info("deleting claim that exists");
        Claim claim = claimRepo.findClaimById(id);

        if (claim == null) {
            throw new InsuranceManagementServiceException("No record found that already exists");
        }

        claimRepo.delete(claim);

        return claimEntityToDto.entityToDto(claim);
    }

    // checking for null inputs - creating a claim
    private void checkForNullInputs(ClaimDto claimDto) {

        if(isNull(claimDto.getClaimNumber())){
            throw new InsuranceManagementServiceException("Claim Number can`t be empty");
        }
        if(isNull(claimDto.getDescription())){
            throw new InsuranceManagementServiceException("Description can`t be empty");
        }
        if (isNull(claimDto.getClaimDate())){
            throw new InsuranceManagementServiceException("Claim date can`t be empty");
        }

        if (isNull(claimDto.getClaimStatus())) {
            throw new InsuranceManagementServiceException("Claim status can't be empty");
        }

        if (isNull(claimDto.getPolicyId())) {
            throw new InsuranceManagementServiceException("Policy id can't be empty");
        }

    }
}
