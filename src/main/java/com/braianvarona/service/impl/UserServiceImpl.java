package com.braianvarona.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braianvarona.entity.User;
import com.braianvarona.exception.ResourceNotFoundException;
import com.braianvarona.repository.UserRepository;
import com.braianvarona.service.UserService;

/**
 * UserService implementation
 * 
 * @author Braian Varona
 *
 */

@Service
public class UserServiceImpl implements UserService {

    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Find user by id.
     *
     * @param id the user id
     * @return the user by id
     * @throws ResourceNotFoundException 
     */
    @Override
    public User getUser(Long id) {
    	log.info("Getting the user with id:" + id);
    	return userRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    /**
     * Store user in database.
     *
     * @param user 
     * @return the user
     */
    @Override
    public User saveUser(User user) {
    	log.info("Saving user...");
        User userToSave = userRepository.save(user);
        return userToSave;        
    }

    /**
     * Remove user from database.
     *
     * @param userId the user id
     * @throws ResourceNotFoundException 
     */
    @Override
    public void deleteUser(Long id) {        
    	log.info("Deleting user with id" + id);
        User user = userRepository.findById(id)
        	.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));            
        userRepository.delete(user);
         
    }
}
