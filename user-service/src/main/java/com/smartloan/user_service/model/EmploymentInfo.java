package com.smartloan.user_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmploymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String income; // You can use BigDecimal if preferred

    private String incomeSources; // Comma-separated or use a separate table for multiple sources
}
