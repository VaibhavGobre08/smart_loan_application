package com.smartloan.user_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditInfoDto {
    private String creditScore;
    private boolean consentToCreditCheck;
}
