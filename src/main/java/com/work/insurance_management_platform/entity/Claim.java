package com.work.insurance_management_platform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimNumber;
    private String description;
    private LocalDate claimDate;
    private String claimStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_policy_id", nullable = false)
    private InsurancePolicy insurancePolicy;
}
