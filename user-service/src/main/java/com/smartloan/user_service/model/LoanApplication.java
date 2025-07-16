package com.smartloan.user_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonalInfo personalInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private EmploymentInfo employmentInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private LoanDetails loanDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private CreditInfo creditInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private SupportingDocuments supportingDocuments;

    private String status; // PENDING, APPROVED, REJECTED

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;
}
