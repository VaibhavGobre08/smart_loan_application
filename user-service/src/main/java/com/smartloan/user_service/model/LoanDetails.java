package com.smartloan.user_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String purpose;

    private Double amount;

    private String term; // e.g., "24 months", or use int for months

    private String preferredPaymentDueDate; // e.g., "5th of each month"
}
