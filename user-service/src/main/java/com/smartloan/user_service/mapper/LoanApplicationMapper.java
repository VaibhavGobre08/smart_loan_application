package com.smartloan.user_service.mapper;

import com.smartloan.user_service.dto.*;
import com.smartloan.user_service.model.*;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationMapper {

    public LoanApplication fromDto(LoanApplicationRequestDto dto) {
        return LoanApplication.builder()
                .status("PENDING")

                .personalInfo(mapPersonalInfo(dto.getPersonalInfo()))
                .employmentInfo(mapEmploymentInfo(dto.getEmploymentInfo()))
                .loanDetails(mapLoanDetails(dto.getLoanDetails()))
                .creditInfo(mapCreditInfo(dto.getCreditInfo()))
                .supportingDocuments(mapSupportingDocs(dto.getSupportingDocuments()))

                .build();
    }

    private PersonalInfo mapPersonalInfo(PersonalInfoDto dto) {
        if (dto == null) return null;

        return PersonalInfo.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .dateOfBirth(dto.getDateOfBirth())
                .build();
    }

    private EmploymentInfo mapEmploymentInfo(EmploymentInfoDto dto) {
        if (dto == null) return null;

        return EmploymentInfo.builder()
                .income(dto.getIncome())
                .incomeSources(dto.getIncomeSources())
                .build();
    }

    private LoanDetails mapLoanDetails(LoanDetailsDto dto) {
        if (dto == null) return null;

        return LoanDetails.builder()
                .amount(dto.getAmount())
                .purpose(dto.getPurpose())
                .term(dto.getTerm())
                .preferredPaymentDueDate(dto.getPreferredPaymentDueDate())
                .build();
    }

    private CreditInfo mapCreditInfo(CreditInfoDto dto) {
        if (dto == null) return null;

        return CreditInfo.builder()
                .creditScore(dto.getCreditScore())
                .consentToCreditCheck(dto.isConsentToCreditCheck())
                .build();
    }

    private SupportingDocuments mapSupportingDocs(SupportingDocumentsDto dto) {
        if (dto == null) return null;

        return SupportingDocuments.builder()
                .bankStatementsUrl(dto.getBankStatementsUrl())
                .governmentIdUrl(dto.getGovernmentIdUrl())
                .proofOfAddressUrl(dto.getProofOfAddressUrl())
                .build();
    }
}
