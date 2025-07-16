package com.smartloan.user_service.service;

import com.smartloan.user_service.model.AppUser;
import com.smartloan.user_service.model.LoanApplication;
import com.smartloan.user_service.repository.AppUserRepository;
import com.smartloan.user_service.repository.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;
    private final AppUserRepository appUserRepository;

    /**
     * Link a loan application to the logged-in AppUser.
     */
    public LoanApplication saveLoanApplicationForUser(LoanApplication application, String email) {
        AppUser user = appUserRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        application.setStatus("PENDING");
        application.setUser(user); // ✅ THIS links the loan to logged-in user

        return loanApplicationRepository.save(application);
    }



    /**
     * Get the latest loan application submitted by the user.
     */
    public Optional<LoanApplication> getLoanApplicationByEmail(String email) {
        return loanApplicationRepository.findByUserEmail(email);
    }

    /**
     * Fetch all loans submitted by a particular user based on email.
     */
    public List<LoanApplication> getAllLoanApplicationsByUserEmail(String email) {
        return loanApplicationRepository.findAllByUserEmail(email);
    }
}
