package com.smartloan.user_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmploymentInfoDto {
    private String income;
    private String incomeSources;
}
