package com.braianvarona.restapi.controller;

import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.any;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.braianvarona.controller.UserRestController;
import com.braianvarona.entity.*;
import com.braianvarona.exception.ResourceNotFoundException;
import com.braianvarona.service.impl.UserServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.BDDMockito.given;

/**
 * 
 * @author Braian Varona
 *
 */

@ContextConfiguration(classes = UserRestController.class)
@WebMvcTest(UserRestController.class)
public class UserControllerAPITest {

	@Autowired
    private MockMvc mockMvc;

	@MockBean
	private UserServiceImpl userService;
	
	User mockUser = new User("juanperez@gmail.com", "Juan", "Perez");

	String exampleUserJson = "{\"email\":\"juanperez@gmail.com\",\"firstName\":\"Juan\",\"lastName\":\"Perez\"}";

	@Test
	public void whenGetValidInput_thenReturns200() throws Exception {
		mockUser.setId(100L);
		String expectedUserJson = "{\"id\":100,\"email\":\"juanperez@gmail.com\",\"firstName\":\"Juan\",\"lastName\":\"Perez\",\"loans\":null}";
		
		given(this.userService.getUser(100L)).willReturn(mockUser);
		mockMvc.perform(get("/users/100")
			    .contentType("application/json"))
			    .andExpect(status().isOk())
			    .andExpect(content().json(expectedUserJson));
	}
	
	
	@Test
	public void whenGetInvalidInput_thenReturns400() throws Exception {
		given(this.userService.getUser(200L)).willThrow(new ResourceNotFoundException("User", "id", 100L));

		mockMvc.perform(get("/users/200")
			    .contentType("application/json"))
			    .andExpect(status().isNotFound());
	}


	@Test
	public void whenPostValidInput_thenReturns200() throws Exception {	

		given(this.userService.saveUser(any(User.class))).willReturn(mockUser);
		
        mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(exampleUserJson))
        	.andExpect(status().isCreated());
	}

	@Test
	public void whenDeleteValidInput_thenReturns200() throws Exception {

	    this.mockMvc.perform(MockMvcRequestBuilders
	            .delete("/users/1")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON))
	            	.andExpect(status().isOk());
	}

}
