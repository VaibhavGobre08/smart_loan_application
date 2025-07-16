package com.smartloan.user_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupportingDocumentsDto {
    private String governmentIdUrl;
    private String proofOfAddressUrl;
    private String bankStatementsUrl;
}
