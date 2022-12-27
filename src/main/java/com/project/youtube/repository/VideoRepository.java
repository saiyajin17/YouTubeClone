package com.project.youtube.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.youtube.model.Video;

public interface VideoRepository extends MongoRepository<Video, Integer> {
	
	
}
