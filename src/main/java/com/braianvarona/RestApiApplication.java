package com.braianvarona;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.braianvarona.entity.Loan;
import com.braianvarona.entity.User;
import com.braianvarona.repository.LoanRepository;
import com.braianvarona.repository.UserRepository;

/**
 * @author Braian Varona
 *
 */

@SpringBootApplication
public class RestApiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RestApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(UserRepository userRepository, LoanRepository loanRepository) {
		return (args) -> {
			
			log.info("Loading initial data...");
			
			User pepe = new User("pepe.argento@gmail.com","Pepe","Argento" );			
			User moni = new User("moni_argento@gmail.com","Moni","Argento");			
			User mariaElena = new User("mefuseneco@gmail.com","Maria Elena","Fuseneco");			
			User dardo = new User("dardo-fuseneco@gmail.com","Dardo","Fuseneco");

			Loan firstLoadPepe = new Loan(50000f,pepe);			
			Loan secondLoadPepe = new Loan(25000f, pepe);
			Loan firstLoadMoni = new Loan(15000f,moni);
			Loan firstLoadDardo = new Loan(4500.50f,dardo);
			
			List<Loan> loans = new ArrayList<Loan>();
			loans.add(firstLoadPepe);
			loans.add(secondLoadPepe);
			pepe.setLoans(loans);
			
			loans = new ArrayList<Loan>();
			loans.add(firstLoadMoni);
			moni.setLoans(loans);
			
			loans = new ArrayList<Loan>();
			loans.add(firstLoadDardo);
			dardo.setLoans(loans);
			
			userRepository.save(pepe);
			userRepository.save(moni);
			userRepository.save(mariaElena);
			userRepository.save(dardo);
		};
	}
}
