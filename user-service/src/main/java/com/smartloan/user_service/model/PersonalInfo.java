package com.smartloan.user_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String dateOfBirth; // Use LocalDate if you want

    private String email;

    private String phoneNumber;

    private String address;
}
