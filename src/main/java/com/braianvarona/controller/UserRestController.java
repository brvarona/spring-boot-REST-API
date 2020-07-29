package com.braianvarona.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.braianvarona.entity.User;
import com.braianvarona.exception.ResourceNotFoundException;
import com.braianvarona.service.UserService;


/**
 * UserRestController implementation
 * 
 * @author Braian Varona
 *
 */

@RestController
public class UserRestController {

    private Logger log = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

    /**
     * Get user by id.
     *
     * @param id the user id
     * @return the user
     * @throws ResourceNotFoundException 
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
        log.info("GET - /users/" + id);
    	User user =  userService.getUser(id);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("POST - /users");
        User created = userService.saveUser(user);
        return new ResponseEntity<User>(created, new HttpHeaders(), HttpStatus.CREATED);
    }

    /**
     * Delete user.
     *
     * @param id the user id
     * @return response 
     * @throws ResourceNotFoundException 
     */
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id) {
        log.info("DELETE - /users/" + id);
    	userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
    
}
