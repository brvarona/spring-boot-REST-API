package com.braianvarona.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 * @author Braian Varona
 * 
 */
 
@Entity
@Table(name = "USERS")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqUserId")	
	@SequenceGenerator(name = "seqUserId", sequenceName = "seq_user_id", initialValue = 1)
	@Column(name="id")
	private Long id;

	@Column(name="email")
	private String email;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@OneToMany(mappedBy="user",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Loan> loans;
	
	public User() {}
	
	public User(String email, String firstName, String lastName) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}	

}