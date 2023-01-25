package com.project.youtube.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.youtube.model.User;
import com.project.youtube.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getCurrentUser(String userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Cannot find video by id - " + userId));
	}

	public boolean ifLikedVideo(String videoId, String userId) {
		return getCurrentUser(userId).getLikedVideos().stream().anyMatch(likedVideo -> likedVideo.equals(videoId));
	}

	public boolean ifDisLikedVideo(String videoId, String userId) {
		return getCurrentUser(userId).getDislikedVideos().stream().anyMatch(likedVideo -> likedVideo.equals(videoId));
	}

	public void removeFromLikedVideos(String videoId, String userId) {
		User currentUser = getCurrentUser(userId);
		currentUser.removeFromLikedVideos(videoId);
		userRepository.save(currentUser);
	}

	public void removeFromDisLikedVideo(String videoId, String userId) {
		User currentUser = getCurrentUser(userId);
		currentUser.removeFromDisLikedVideos(videoId);
		userRepository.save(currentUser);
	}

	public void addToLikedVideos(String videoId, String userId) {
		User currentUser = getCurrentUser(userId);
		currentUser.addToLikedVideos(videoId);
		userRepository.save(currentUser);
	}

	public void addToDisLikedVideos(String videoId, String userId) {
		User currentUser = getCurrentUser(userId);
		currentUser.addToDisLikedVideos(videoId);
		userRepository.save(currentUser);
	}

	public void addToVideoHistory(String videoId, String userId) {
		User currentUser = getCurrentUser(userId);
		currentUser.addToVideoHistory(videoId);
		userRepository.save(currentUser);
	}

	public void subscribeUser(String userId, String currUserId) {
		User currentUser = getCurrentUser(currUserId);
		currentUser.addToSubscribedToUsers(userId);

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Cannot find user with userId: " + userId));

		user.addToSubscribers(currentUser.getId());
		userRepository.save(currentUser);
		userRepository.save(user);
	}

	public void unSubscribeUser(String userId, String currUserId) {
		User currentUser = getCurrentUser(currUserId);
		currentUser.removeFromSubscribedToUsers(userId);

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Cannot find user with userId: " + userId));

		user.removeFromSubscribers(currentUser.getId());
		userRepository.save(currentUser);
		userRepository.save(user);
	}

	public Set<String> userHistory(String userId) {
		User user = getCurrentUser(userId);
		return user.getVideoHistory();
	}

}
