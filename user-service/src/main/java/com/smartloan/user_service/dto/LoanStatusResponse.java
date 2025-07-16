package com.smartloan.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanStatusResponse {
    private Long loanId;
    private String applicantName;
    private double amount;
    private String status;
    private String term;
}
