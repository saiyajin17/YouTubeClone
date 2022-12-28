package com.project.youtube.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.youtube.model.Video;

public interface VideoRepository extends MongoRepository<Video, BigInteger> {

	Video findById(String id);
	
	
}
