package com.smartloan.user_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalInfoDto {
    private String fullName;
    private String dateOfBirth; // or use LocalDate
    private String email;
    private String phoneNumber;
    private String address;
}
