package com.braianvarona.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.braianvarona.dto.PageLoansDTO;
import com.braianvarona.exception.ResourceNotFoundException;
import com.braianvarona.service.LoanService;

/**
 * LoanRestController implementation
 * 
 * @author Braian Varona
 *
 */

@RestController
public class LoanRestController {	
	
    private Logger log = LoggerFactory.getLogger(LoanRestController.class);

	@Autowired
	private LoanService loanService;
	
	/**
     * Get loans by user id.
     *
     * @param paging with page and size 
     * @param id the user id
     *
     * @return response that contains a list of loans and paging statistics
	 * @throws ResourceNotFoundException 
     */
	@GetMapping("/loans")
	public ResponseEntity<PageLoansDTO> getLoans(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, @RequestParam(name = "user_id", required = false) Long userId) { 
		log.info("GET - /loans?&page=" + page + "&size=" + size + "userId=" + userId);
		PageLoansDTO pageLoans = loanService.getLoans(PageRequest.of(page, size), userId);	
			
        return new ResponseEntity<PageLoansDTO>(pageLoans, new HttpHeaders(), HttpStatus.OK); 
    }

}
