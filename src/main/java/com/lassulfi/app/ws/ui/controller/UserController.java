package com.lassulfi.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value="page") Integer page, @RequestParam(value="limit") Integer limit) {
		return "GET /users was called with page = " + page + " and limit = " + limit;
	}
	
	@GetMapping(path="/{userId}")
	public String getUser(@PathVariable String userId) {
		return "GET /users was called with userId = " + userId;
	}
	
	@PostMapping
	public String createUser() {
		return "POST /users was called";
	}
	
	@PutMapping
	public String updateUser() {
		return "PUT /users was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "DELETE /users was called"; 
	}
}
