package com.project.youtube.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.youtube.model.User;
import com.project.youtube.service.UserRegistrationService;
import com.project.youtube.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
		
	@Autowired
	private UserRegistrationService userRegService;
	@Autowired
	private UserService userservice;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public String register(@RequestBody User user) {
		userRegService.registerUser(user);
		return "User Registration is successfull";
	}
	
	@GetMapping("/{userId}")
	@ResponseStatus(code = HttpStatus.OK)
	public User getUser(@PathVariable String userId) {
		return userRegService.getUser(userId);
	}
	
	@PostMapping("/subscribe")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean subscribeUser(@RequestParam String userId,@RequestParam String currUserId) {
		userservice.subscribeUser(userId,currUserId);
		return true;
	}
	
	@PostMapping("/unsubscribe")
	@ResponseStatus(code = HttpStatus.OK)
	public boolean unSubscribeUser(@RequestParam String userId,@RequestParam String currUserId) {
		userservice.unSubscribeUser(userId,currUserId);
		return true;
	}
	
	@GetMapping("/{userId}/history")
	@ResponseStatus(code = HttpStatus.OK)
	public Set<String> userHistory(@PathVariable String userId){
		return userservice.userHistory(userId);
	}
}
