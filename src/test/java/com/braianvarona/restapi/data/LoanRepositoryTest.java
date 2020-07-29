package com.braianvarona.restapi.data;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.braianvarona.entity.Loan;
import com.braianvarona.entity.User;
import com.braianvarona.repository.LoanRepository;

/**
 * 
 * @author Braian Varona
 *
 */

@DataJpaTest
public class LoanRepositoryTest {

	@Autowired
    private TestEntityManager testEntityManager;
	
	@Autowired
	private LoanRepository loanRepository;

	@Test
	public void whenInitialized_thenFindsByUserId() {
		User userTest = new User("juanperez@gmail.com", "Juan", "Perez");
		userTest = testEntityManager.persist(userTest);
        
        Loan loanOne = new Loan(6000f, userTest);
        Loan loanTwo = new Loan(2500f, userTest);

        testEntityManager.persist(loanOne);
        testEntityManager.persist(loanTwo);

		Page<Loan> loans = loanRepository.findByUserId(userTest.getId(), PageRequest.of(0, 10));		
		assertEquals(2, loans.getTotalElements());
	}
}
