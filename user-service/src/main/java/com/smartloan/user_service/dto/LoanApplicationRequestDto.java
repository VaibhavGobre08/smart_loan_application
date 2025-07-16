package com.smartloan.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationRequestDto {
    private PersonalInfoDto personalInfo;
    private EmploymentInfoDto employmentInfo;
    private LoanDetailsDto loanDetails;
    private CreditInfoDto creditInfo;
    private SupportingDocumentsDto supportingDocuments;
}
