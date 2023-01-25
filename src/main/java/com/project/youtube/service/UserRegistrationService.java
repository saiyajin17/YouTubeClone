package com.project.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.youtube.model.User;
import com.project.youtube.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(User user) {
		userRepository.save(user);
	}

	public User getUser(String userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Cannot find video by id - " + userId));
		
	}
}
