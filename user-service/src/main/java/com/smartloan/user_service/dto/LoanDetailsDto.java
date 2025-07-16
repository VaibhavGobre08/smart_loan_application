package com.smartloan.user_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanDetailsDto {
    private String purpose;
    private double amount;
    private String term;
    private String preferredPaymentDueDate;
}
