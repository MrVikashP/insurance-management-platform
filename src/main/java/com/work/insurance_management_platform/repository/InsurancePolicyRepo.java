package com.work.insurance_management_platform.repository;

import com.work.insurance_management_platform.entity.Client;
import com.work.insurance_management_platform.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy, Long> {

    List<InsurancePolicy> findAll();

    @Query
    InsurancePolicy findInsurancePolicyById(Long id);


}
