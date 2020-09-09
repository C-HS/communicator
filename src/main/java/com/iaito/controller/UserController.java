package com.iaito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iaito.dto.UserDTO;
import com.iaito.model.User;
import com.iaito.model.UserLogin;
import com.iaito.service.UserService;

@RestController
public class UserController {
	@Autowired UserService userService;
	
	@PostMapping(value = "/user", consumes = "application/json")
	public ResponseEntity<String> addUser(@RequestBody User user){
		userService.addUser(user);
		return ResponseEntity.ok("Saved Successfuly");
	}
	
	@GetMapping(value = "/user/{userId}", produces = "application/json")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") long userId){
		return ResponseEntity.ok(userService.findUserById(userId));
	}
	
	@GetMapping(value = "/user/{username}", produces = "application/json")
	public ResponseEntity<UserDTO> getUserByUsername(@PathVariable("username") String username){
		return ResponseEntity.ok(userService.findUserByUserName(username));
	}
	
	@GetMapping(value = "/user", consumes = "application/json")
	public ResponseEntity<Boolean> userLogin(@RequestBody UserLogin userLogin){
		return ResponseEntity.ok(userService.userLogin(userLogin.getUsername(), userLogin.getPasswd()));
	} 
	
	@PutMapping(value = "/user", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserDTO> updateUser(@RequestBody User user){
		return null;
	}
	
	@DeleteMapping(value = "/user", consumes = "application/json")
	public ResponseEntity<String> deleteUser(@RequestBody User user){
		return ResponseEntity.ok("User Removed Successfully");
	}
}
