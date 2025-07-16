package com.smartloan.user_service.controller;

import com.smartloan.user_service.model.LoanApplication;
import com.smartloan.user_service.dto.LoanStatusResponse;
import com.smartloan.user_service.mapper.LoanApplicationMapper;
import com.smartloan.user_service.service.LoanApplicationProducer;
import com.smartloan.user_service.service.LoanApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import com.smartloan.user_service.dto.LoanApplicationRequestDto;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanApplicationController {

    private final LoanApplicationProducer loanApplicationProducer;
    private final LoanApplicationService loanApplicationService;
    private final LoanApplicationMapper loanApplicationMapper;

//    @PostMapping("/apply")
//    public ResponseEntity<String> applyForLoan(@RequestBody LoanApplication loanApplication) {
//        loanApplicationProducer.sendLoanApplication(loanApplication);
//        return ResponseEntity.ok("Loan application has been submitted and sent to processing queue.");
//    }
    
//    @PostMapping("/apply")
//    public ResponseEntity<?> applyForLoan(@RequestBody LoanApplication loanApplication,
//                                          @AuthenticationPrincipal UserDetails userDetails) {
//        String email = userDetails.getUsername(); // extracted from JWT
//
//        // Save loan, linked with currently authenticated user
//        loanApplicationService.saveLoanApplicationForUser(loanApplication, email);
//        loanApplicationProducer.sendLoanApplication(loanApplication);
//
//        return ResponseEntity.ok("Loan application has been submitted and sent to processing queue.");
//    }
    
    
    @PostMapping("/apply")
    public ResponseEntity<String> applyForLoan(
            @RequestBody LoanApplicationRequestDto loanRequest,
            @AuthenticationPrincipal UserDetails userDetails) {

        String email = userDetails.getUsername();

        LoanApplication application = loanApplicationMapper.fromDto(loanRequest); // ✅ Call instance method

        loanApplicationService.saveLoanApplicationForUser(application, email);

        return ResponseEntity.ok("Loan submitted successfully!");
    }


    @GetMapping("/check-status")
    public ResponseEntity<List<LoanStatusResponse>> getAllLoanStatusesByUser(
            @AuthenticationPrincipal UserDetails userDetails) {

        String email = userDetails.getUsername(); // From JWT-authenticated user

        List<LoanApplication> loans = loanApplicationService.getAllLoanApplicationsByUserEmail(email);

        List<LoanStatusResponse> responses = loans.stream()
                .map(application -> new LoanStatusResponse(
                        application.getId(),
                        application.getPersonalInfo().getFullName(),
                        application.getLoanDetails().getAmount(),
                        application.getStatus(),
                        application.getLoanDetails().getTerm()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }}

