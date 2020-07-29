package com.braianvarona.service;


import org.springframework.data.domain.Pageable;

import com.braianvarona.dto.PageLoansDTO;

/**
 * Interface LoanService
 * 
 * @author Braian Varona
 *
 */

public interface LoanService {

	public PageLoansDTO getLoans(Pageable paging, Long userId);

}
