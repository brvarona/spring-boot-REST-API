package com.braianvarona.service;

import com.braianvarona.entity.User;

/**
 * Interface UserService
 * 
 * @author Braian Varona
 *
 */

public interface UserService {

	public User getUser(Long id);
	    
	public User saveUser(User user);

	public void deleteUser(Long id);
}
