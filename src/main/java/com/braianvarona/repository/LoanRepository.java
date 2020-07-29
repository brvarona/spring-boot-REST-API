package com.braianvarona.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.braianvarona.entity.Loan;

/**
 * Loan Repository
 * 
 * @author Braian Varona
 *
 */

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	Page<Loan> findByUserId(Long id, Pageable pageable);
	
}