package com.smartloan.user_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupportingDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String governmentIdUrl;   

    private String proofOfAddressUrl; 

    private String bankStatementsUrl;
}
