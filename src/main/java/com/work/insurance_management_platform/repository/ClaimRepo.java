package com.work.insurance_management_platform.repository;

import com.work.insurance_management_platform.entity.Claim;
import com.work.insurance_management_platform.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClaimRepo extends JpaRepository<Claim, Long> {
    List<Claim> findAll();
    @Query
    Claim findClaimById(Long id);


}
