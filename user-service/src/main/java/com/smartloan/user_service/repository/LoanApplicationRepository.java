package com.smartloan.user_service.repository;

import com.smartloan.user_service.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
	Optional<LoanApplication> findByUserEmail(String email);
	
	List<LoanApplication> findAllByUserEmail(String email);
}



