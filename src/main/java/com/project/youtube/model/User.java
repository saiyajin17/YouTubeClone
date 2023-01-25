package com.project.youtube.model;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "User")
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String emailAddress;
	private String password;
	private String sub;
	private Set<String> subscribedToUsers=ConcurrentHashMap.newKeySet();
	private Set<String> subscribers=ConcurrentHashMap.newKeySet();
	private Set<String> videoHistory = ConcurrentHashMap.newKeySet();
	private Set<String> likedVideos = ConcurrentHashMap.newKeySet();
	private Set<String> dislikedVideos=ConcurrentHashMap.newKeySet();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set<String> getSubscribedToUsers() {
		return subscribedToUsers;
	}

	public void setSubscribedToUsers(Set<String> subscribedToUsers) {
		this.subscribedToUsers = subscribedToUsers;
	}

	public Set<String> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<String> subscribers) {
		this.subscribers = subscribers;
	}

	public Set<String> getVideoHistory() {
		return videoHistory;
	}

	public void setVideoHistory(Set<String> videoHistory) {
		this.videoHistory = videoHistory;
	}

	public Set<String> getLikedVideos() {
		return likedVideos;
	}

	public void setLikedVideos(Set<String> likedVideos) {
		this.likedVideos = likedVideos;
	}

	public Set<String> getDislikedVideos() {
		return dislikedVideos;
	}

	public void setDislikedVideos(Set<String> dislikedVideos) {
		this.dislikedVideos = dislikedVideos;
	}

	public User() {
		super();
	}

	public User(String id, String firstName, String lastName, String fullName, String emailAddress, String password,
			Set<String> subscribedToUsers, Set<String> subscribers, Set<String> videoHistory, Set<String> likedVideos,
			Set<String> dislikedVideos,String sub) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.subscribedToUsers = subscribedToUsers;
		this.subscribers = subscribers;
		this.videoHistory = videoHistory;
		this.likedVideos = likedVideos;
		this.sub=sub;
		this.dislikedVideos = dislikedVideos;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName
				+ ", emailAddress=" + emailAddress + ", password=" + password + ", subscribedToUsers="
				+ subscribedToUsers + ", subscribers=" + subscribers + ", videoHistory=" + videoHistory
				+ ", likedVideos=" + likedVideos + ", dislikedVideos=" + dislikedVideos + "]";
	}
	
	
	/******************Custom Methods**************************/
	public void addToLikedVideos(String videoId) {
		likedVideos.add(videoId);
	}

	public void removeFromLikedVideos(String videoId) {
		likedVideos.remove(videoId);
	}

	public void removeFromDisLikedVideos(String videoId) {
		dislikedVideos.remove(videoId);
	}

	public void addToDisLikedVideos(String videoId) {
		dislikedVideos.add(videoId);
	}

	public void addToVideoHistory(String videoId) {
		videoHistory.add(videoId);
	}

	public void addToSubscribedToUsers(String userId) {
		subscribedToUsers.add(userId);
	}

	public void addToSubscribers(String currentUser) {
		subscribers.add(currentUser);
	}

	public void removeFromSubscribedToUsers(String userId) {
		subscribedToUsers.remove(userId);
	}

	public void removeFromSubscribers(String userId) {
		subscribers.remove(userId);
	}
	
	
}
