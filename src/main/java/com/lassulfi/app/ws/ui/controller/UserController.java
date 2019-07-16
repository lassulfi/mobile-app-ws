package com.lassulfi.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lassulfi.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.lassulfi.app.ws.ui.model.request.UserDetailsRequestModel;
import com.lassulfi.app.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	Map<String, UserRest> users;

	@GetMapping
	public String getUsers(@RequestParam(value="page", defaultValue = "1") Integer page, 
			@RequestParam(value="limit", defaultValue="50") Integer limit, 
			@RequestParam(value="sort", defaultValue="desc", required = false) String sort) {
		return "GET /users was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}
	
	@GetMapping(path="/{userId}", 
			produces = { 
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE 
					})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PostMapping(consumes = { 
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE 
					}, 
				produces = { 
						MediaType.APPLICATION_XML_VALUE, 
						MediaType.APPLICATION_JSON_VALUE 
						})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, returnValue);
		
		return new ResponseEntity<UserRest>(returnValue, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{userId}", consumes = { 
					MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE 
					}, 
				produces = { 
						MediaType.APPLICATION_XML_VALUE, 
						MediaType.APPLICATION_JSON_VALUE 
						})
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, 
			@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		
		if(!users.containsKey(userId)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		UserRest storedUserDetais = users.get(userId);
		storedUserDetais.setFirstName(userDetails.getFirstName());
		storedUserDetais.setLastName(userDetails.getLastName());
		
		users.put(userId, storedUserDetais);
		
		
		return new ResponseEntity<>(storedUserDetais, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "DELETE /users was called"; 
	}
}
